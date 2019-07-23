package com.stylefeng.guns.rest.modular.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.consumer.service.ConsumerService;
import com.stylefeng.guns.rest.modular.consumer.vo.UserInfoModel;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import com.stylefeng.guns.rest.modular.order.vo.ExceptionResponseVO;
import com.stylefeng.guns.rest.modular.order.vo.OrderVO;
import com.stylefeng.guns.rest.modular.order.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Reference(check = false)
    OrderService orderService;
    @Reference(check = false)
    ConsumerService consumerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("buyTickets")
    public Object buyTickets(HttpServletRequest request,String fieldId, String soldSeats, String seatsName) {
        ResponseVo<OrderVO> responseVo = new ResponseVo<>();
        ExceptionResponseVO exceptionResponseVO = new ExceptionResponseVO();
        //校验参数
        if(soldSeats == null || fieldId == null) {
            exceptionResponseVO.setMsg("系统出现异常，请联系管理员");
            exceptionResponseVO.setStatus(999);
            return exceptionResponseVO;
        }

        String[] split = soldSeats.split(","); //获得座位数组

        //校验该座位是否存在
        for(String soldSeat : split) {
            Boolean isTrueSeat = orderService.isTrueSeats(fieldId, soldSeat);
            if(!isTrueSeat) {
                exceptionResponseVO.setMsg("该座位不存在");
                exceptionResponseVO.setStatus(1);
                return exceptionResponseVO;
            }
        }
        //校验该座位是否已卖出
        for(String soldSeat : split) {
            Boolean isSoldSeat = orderService.isSoldSeats(fieldId, soldSeat);
            if(isSoldSeat) {
                exceptionResponseVO.setMsg("该座位已被购买");
                exceptionResponseVO.setStatus(1);
                return exceptionResponseVO;
            }
        }

        //判断token是否过期
        Jedis jedis = new Jedis();
        String token = request.getHeader("Authorization");                                                  //从头文件中得到token
        token = token.substring(7, token.length());                                                             //去掉token的前缀
        String username = jwtTokenUtil.getUsernameFromToken(token);
        String tokenFromRedis = jedis.get(username);
        if(tokenFromRedis == null) {
            exceptionResponseVO.setMsg("token验证失败");
            exceptionResponseVO.setStatus(700);
            return exceptionResponseVO;
        }

        //插入order
        UserInfoModel userInfoModel = consumerService.queryUserByUsername(username);
        Integer uuid = userInfoModel.getUuid();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            String seatName = orderService.getSeatName(fieldId, split[i]);
            sb.append(seatName);
            if(i != split.length - 1) {
                sb.append(",");
            }
        }
        seatsName = sb.toString();

        OrderVO orderVO = orderService.saveOrderInfo(fieldId, soldSeats, seatsName, uuid);

        responseVo.setData(orderVO);
        responseVo.setMsg("");
        responseVo.setStatus(0);

        return responseVo;
    }


    @PostMapping("getOrderInfo")
    public Object getOrderInfo(HttpServletRequest request, Integer nowPage, Integer pageSize) {
        ResponseVo<List<OrderVO>> responseVo = new ResponseVo<>();
        ExceptionResponseVO exceptionResponseVO = new ExceptionResponseVO();
        //判断token是否过期
        Jedis jedis = new Jedis();
        String token = request.getHeader("Authorization");                                                  //从头文件中得到token
        token = token.substring(7, token.length());                                                             //去掉token的前缀
        String username = jwtTokenUtil.getUsernameFromToken(token);
        String tokenFromRedis = jedis.get(username);
        if(tokenFromRedis == null) {
            exceptionResponseVO.setMsg("token验证失败");
            exceptionResponseVO.setStatus(700);
            return exceptionResponseVO;
        }

        //获取userId
        UserInfoModel userInfoModel = consumerService.queryUserByUsername(username);
        Integer uuid = userInfoModel.getUuid();

        List<OrderVO> list = orderService.getOrderByUserId(uuid, nowPage, pageSize);
        responseVo.setStatus(0);
        responseVo.setMsg("");
        responseVo.setData(list);
        return responseVo;
    }
}

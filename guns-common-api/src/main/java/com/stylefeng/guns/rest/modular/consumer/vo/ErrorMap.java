package com.stylefeng.guns.rest.modular.consumer.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-17-23:35
 */
public class ErrorMap {
    //询问同学这里需要写静态方法，然后用一个map把这些塞进去，如果返回值需要data就塞data，如果需要msg，那个不是查询出来的就直接在方法里put。
    public static Map<Object, Object> getfile1(Object object){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("data",object);
        objectObjectHashMap.put("status", 0);
        return objectObjectHashMap;
    }
    public static Map<Object, Object> getfile2(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("msg","用户信息修改失败");
        objectObjectHashMap.put("status", 1);
        return objectObjectHashMap;
    }
    public static Map<Object, Object> getfile3(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("status", 999);
        objectObjectHashMap.put("msg","系统出现异常，请联系管理员");
        return objectObjectHashMap;
    }
}

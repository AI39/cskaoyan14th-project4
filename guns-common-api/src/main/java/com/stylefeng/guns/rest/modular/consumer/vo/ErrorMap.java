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
        objectObjectHashMap.put("status", 0);
        objectObjectHashMap.put("data",object);

        return objectObjectHashMap;
    }
    public static Map<Object, Object> getfile2(int status, String msg){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("status", status);
        objectObjectHashMap.put("msg",msg);
        return objectObjectHashMap;
    }
    /*public static Map<Object, Object> getfile3(int status, String msg){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("status", status);
        objectObjectHashMap.put("msg",msg);
        return objectObjectHashMap;
    }*/
    /*上面的3可以不用要*/
}

package com.example.springboot.common;

import com.sun.deploy.net.HttpUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * #date：2020/12/15 <br/>
 * #param:  <br/>
 * #return: <br/>
 */
public class WeXin {
    public static void main(String[] args) {
        Long nowDate1 = new Date().getTime();
        Long nowDate=System.currentTimeMillis();
        System.out.println(nowDate);
        System.out.println(nowDate1);
    }
}

package com.example.demo.controller;

import com.example.demo.pojo.ApUser;
import com.example.demo.utils.jwt.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-06-13
 * @time 22:46
 **/
@RestController
public class TestController {
    private static final Map<String,String> userMap = new HashMap<>();
    static {
        userMap.put("123","123" );
        userMap.put("123456", "123456");
    }
    @RequestMapping("/login")
    public ApUser login(ApUser apUser){
        //参数校验
        String username = apUser.getName();
        if (StringUtils.isEmpty(username))return null;
        String password = apUser.getPassword();
        if (StringUtils.isEmpty(password))return null;
        //验证用户是否存在
        if (userMap.containsKey(username)&&password.equals(userMap.get(username))){
            String token = AppJwtUtil.getToken(apUser);
            apUser.setToken(token);
            return apUser;
        }
        return null;
    }


    @RequestMapping("/read")
    public String login(){
        return "success";
    }

}

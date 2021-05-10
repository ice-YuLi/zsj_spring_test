package com.zsj.core.login.controller;

import com.zsj.core.BaseCore.controller.BaseController;
import com.zsj.core.login.domain.LoginUserDomain;
import com.zsj.core.login.service.LoginService;
import com.zsj.core.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {

    @Autowired
    LoginService loginService;
    @Autowired
    RedisService redisService;

    @RequestMapping(value="/sign", method= RequestMethod.GET)
    public String sign(){
        System.out.println("跳转到登录界面...");
        return "index";  //在视图解析器中配置了前缀后缀
    }

    @RequestMapping(value="/sign", method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(LoginUserDomain loginUserDomain){
        Map<String, Object> map = new HashMap<>();
        map.put("userName", loginUserDomain.getUserName());
        map.put("password", loginUserDomain.getPassword());

        String name = (String)redisService.get("name");

        loginService.queryUser(1);

        return map;
    }
}

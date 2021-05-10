package com.zsj.core.login.service.impl;

import com.zsj.core.login.dao.LoginDao;
import com.zsj.core.login.domain.LoginUserDomain;
import com.zsj.core.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

//    @Autowired
//    LoginDao loginDao;

    public void save (LoginUserDomain loginUserDomain){
//        loginDao.save(loginUserDomain);
    }

    public LoginUserDomain queryUser (Integer id){
//        return loginDao.queryUser(id);
        System.out.print("我是猪！！！");
         return null;
    }
}

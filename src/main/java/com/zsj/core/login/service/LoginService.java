package com.zsj.core.login.service;

import com.zsj.core.login.domain.LoginUserDomain;

public interface LoginService {

    public void save (LoginUserDomain loginUserDomain);

    public LoginUserDomain queryUser (Integer id);
}

package com.zsj.core.login.dao;

import com.zsj.core.login.domain.LoginUserDomain;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    public void save (LoginUserDomain loginUserDomain);

    public LoginUserDomain queryUser (Integer id);
}

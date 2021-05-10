package com.zsj.core.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zsj.core.login.domain.LoginUserDomain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    private static final String SECRET = "zhishengjie";

    private static final Long EXPIRESDATE = 15 * 60 * 1000L;

    public static String getToken(LoginUserDomain user) {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        // 设置过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRESDATE);
        // 私钥和加密算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET);


        String token=JWT.create()
                .withHeader(header)
                .withClaim("id", user.getId())
                .withAudience(user.getId())
                .withExpiresAt(date)
                .sign(algorithm);
        return token;
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 从token中获取username信息
     * @param **token**
     * @return
     */
    public static String getUserName(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        LoginUserDomain user = new LoginUserDomain();
        user.setId("1");
        user.setPassword("123456");
        String token = getToken(user);
        System.out.println(token);
    }

}


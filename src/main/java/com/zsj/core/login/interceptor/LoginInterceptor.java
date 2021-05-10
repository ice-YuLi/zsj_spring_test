//package com.zsj.core.login.interceptor;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.zsj.core.login.domain.LoginUserDomain;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        // 如果不是映射到方法直接通过
////        if (!(handler instanceof HandlerMethod)) {
////            return true;
////        }
////        String token = request.getHeader("token");
////
////        if (token == null) {
////            throw new RuntimeException("无token，请重新登录");
////        }
////        String userId;
////        try {
////            userId = JWT.decode(token).getAudience().get(0);
////        } catch (JWTDecodeException j) {
////            throw new RuntimeException("401");
////        }
//////        User user = userService.findUserById(userId);
////        LoginUserDomain user = new LoginUserDomain();
////        user.setPassword("123456");
////        if (user == null) {
////            throw new RuntimeException("用户不存在，请重新登录");
////        }
////
////        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
////        try {
////            jwtVerifier.verify(token);
////        } catch (JWTVerificationException e) {
////            throw new RuntimeException("401");
////        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}

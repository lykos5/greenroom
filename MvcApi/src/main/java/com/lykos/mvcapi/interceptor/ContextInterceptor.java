package com.lykos.mvcapi.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lykos on 15/9/8.
 */
public class ContextInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
//        String url = request.getRequestURL().toString();
//        if(url.endsWith("login")){
//            return true;
//        }else{
//            if(request.getSession().getAttribute(Const.LOGIN_USER)==null){
//                response.sendRedirect("");
//                return false;
//            }
//        }
        return true;
    }

    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception {
    }


    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    public void afterConcurrentHandlingStarted(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
    }
}

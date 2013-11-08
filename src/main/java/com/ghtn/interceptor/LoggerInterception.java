package com.ghtn.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Administrator
 * Date: 13-11-8
 * Time: 下午5:17
 */
public class LoggerInterception extends HandlerInterceptorAdapter {
    private static Logger logger = Logger.getLogger(LoggerInterception.class);

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.debug("========modelAndView:" + modelAndView + "==========");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.debug("=======request:" + request.getRequestURI() + "=========");

        return super.preHandle(request, response, handler);
    }
}

package com.jacklin.myshop.interceptor;

import com.jacklin.myshop.entity.AdminUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登入拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个请求检查是否已经登入
        logger.info("LoginInterceptor.preHandle拦截器执行");
        AdminUser loginName = (AdminUser) request.getSession().getAttribute("loginName");
        //如果等于Null，则拦截请求
        if (loginName == null) {
            response.sendRedirect("/admin/login");
            //拦截
            return false;
        }
        //放行
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

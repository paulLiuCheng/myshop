package com.jacklin.myshop.config;

import com.jacklin.myshop.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    //注册一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor interceptor = new LoginInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(interceptor);

        //拦截路径
        interceptorRegistration.addPathPatterns("/**");
        // 排除路径
        interceptorRegistration.excludePathPatterns("/defaultKaptcha/**");
        interceptorRegistration.excludePathPatterns("/admin/login");
        interceptorRegistration.excludePathPatterns("/admin/login_do");
        interceptorRegistration.excludePathPatterns("/loginout");
        // 排除资源请求
        interceptorRegistration.excludePathPatterns("/layuiadmin/**");
    }
}

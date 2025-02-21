package jmu.zx.config;

import jmu.zx.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录接口和注册接口不拦截
        // TODO:将来还有其他用户的登录、注册接口没写
        //这里可能会出错
        String[] page = new String[]
                {
                        "/admin/login", "/admin/register", "/stu/login", "/stu/register",
                        "/employer/login", "/employer/register", "/message/searchAll", "/jobCategory/searchAll",
                        "/jobCategory/searchByCategoryName","/jobPosting/searchAll","/jobPosting/searchByCategoryName"
                };
        registry.addInterceptor(loginInterceptor).excludePathPatterns(page);
    }
}

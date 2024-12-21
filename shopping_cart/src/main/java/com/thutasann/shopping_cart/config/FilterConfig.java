package com.thutasann.shopping_cart.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thutasann.shopping_cart.utils.LoggerFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggerFilter> loggingFilter() {
        FilterRegistrationBean<LoggerFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggerFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

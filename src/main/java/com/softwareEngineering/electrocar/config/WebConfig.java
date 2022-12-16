package com.softwareEngineering.electrocar.config;

import com.softwareEngineering.electrocar.component.PageRequestHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private PageRequestHandlerMethodArgumentResolver pageRequestHandlerMethodArgumentResolver;

    /**
     * 添加自定义参数解析器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageRequestHandlerMethodArgumentResolver);
    }
}

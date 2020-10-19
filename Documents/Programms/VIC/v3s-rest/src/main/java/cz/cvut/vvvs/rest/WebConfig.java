/*
 * Copyright (c) 2019 Czech Technical University in Prague.
 * All Rights Reserved.
 */
package cz.cvut.vvvs.rest;

import cz.cvut.vic.web.resolver.PageRequestHandlerMethodArgumentResolver;
import cz.cvut.vic.web.resolver.SortExpressionParser;
import cz.cvut.vic.web.resolver.SortHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author David Pavel
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * Register argument resolvers for Sort and Page classes
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        SortHandlerMethodArgumentResolver sortArgumentResolver = new SortHandlerMethodArgumentResolver(new SortExpressionParser());
        PageRequestHandlerMethodArgumentResolver pageRequestArgumentResolver = new PageRequestHandlerMethodArgumentResolver(sortArgumentResolver);
        argumentResolvers.add(sortArgumentResolver);
        argumentResolvers.add(pageRequestArgumentResolver);
    }
}

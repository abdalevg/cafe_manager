/*
 * Copyright (c) 2019 Czech Technical University in Prague.
 * All Rights Reserved.
 */
package cz.cvut.vvvs.rest;

import com.fasterxml.classmate.TypeResolver;
import cz.cvut.vvvs.rest.swagger.SortAndPageRequestConvention;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author David Pavel
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("vvvs-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cz.cvut.vvvs.rest"))
                .build();
    }

    @Primary
    @Bean
    public SortAndPageRequestConvention sortAndPageRequestConvention() {
        return new SortAndPageRequestConvention(new TypeResolver());
    }
}

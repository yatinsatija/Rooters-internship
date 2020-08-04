package com.app.rooters.common.web;

import com.app.rooters.web.security.WebSecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.GzipResourceResolver;

import javax.validation.Validator;
import java.util.concurrent.TimeUnit;

/**
 * Common Web config.
 *
 * @author aadgupta
 */
@Configuration
@ComponentScan
@EnableWebMvc
@Slf4j
@Import({WebSecurityConfig.class})
public class CommonWebConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory>, WebMvcConfigurer {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);

        // Add font types for fontawesome
        mappings.add("ttf", "application/x-font-ttf");
        mappings.add("woff2", "application/font-woff2");
        mappings.add("woff", "application/font-woff");
        mappings.add("eot", "application/vnd.ms-fontobject");
        factory.setMimeMappings(mappings);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 30 days. Webjars have their version in the path, so, safe to cache.
        int cacheSeconds = 60 * 60 * 24 * 30;

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .setCachePeriod(cacheSeconds)
                .resourceChain(true)
                .addResolver(new GzipResourceResolver());

        registry.addResourceHandler("/**").addResourceLocations("classpath:/ui/")
                .setCacheControl(CacheControl.maxAge(7, TimeUnit.DAYS));

        registry.addResourceHandler("/index.html")
                .addResourceLocations("classpath:/ui/index.html")
                .setCachePeriod(0);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
    }


    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        return loggingFilter;
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}

package com.glessit.neurofunky.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@Configuration
@ComponentScan(basePackages = {"com.glessit.neurofunky.web"})
@EnableSpringDataWebSupport
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RestConfiguration extends DelegatingWebMvcConfiguration {

    @Bean(value = "simpleHttpClient")
    @Scope(value = "prototype")
    public HttpClient httpClientBean() {
        return HttpClientBuilder.create().build();
    }

    @Bean(value = "simpleObjectMapper")
    public ObjectMapper objectMapperBean() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedHeaders("*")
                .allowedOrigins("http://localhost", "http://localhost:8787")
                .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE");
    }
}

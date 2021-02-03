package com.aaron.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;

@Configuration
public class BeanConfig {

    //设置为火狐浏览器的标识
    private String USER_AGENT = "User-Agent";
    private String USER_AGENT_DETAILS = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0";

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        ClientHttpRequestInterceptor clientHttpRequestInterceptor = new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                HttpHeaders headers = httpRequest.getHeaders();
                headers.add(USER_AGENT, USER_AGENT_DETAILS);
                return clientHttpRequestExecution.execute(httpRequest, bytes);
            }
        };
        restTemplate.setInterceptors(Arrays.asList(clientHttpRequestInterceptor));
        return restTemplate;
    }
}

package com.aaron.security.http;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpTest {

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void httpRequest(){
        String url = "http://localhost/";
        String cookie = "Hm_lvt_82116c626a8d504a5c0675073362ef6f=1583391821,1583464293; _ga=GA1.1.556433683.1582702896; Idea-d32c8d37=2f7fb27e-fbfb-4cf7-a763-ca1a1a6b3d72; JSESSIONID=5D9ECF2915BB3213F0A89CDAC80617A4";
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Cookie", cookie);
        HttpEntity httpEntity = new HttpEntity( header);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        HttpHeaders headers = exchange.getHeaders();
        String s = headers.toString();
        System.out.println("s = " + s);
//        headers.stream().filter(e -> e != null).forEach(System.out::println);
        System.out.println(exchange.getBody());
    }
}

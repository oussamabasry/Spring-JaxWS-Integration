package com.basry.springjaxwsintegration.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class SoapConfig {
    private String url = "http://0.0.0.0:8084/bankService/";
    @Bean
    public SimpleJaxWsServiceExporter serviceExporter(){
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress(url);
        return serviceExporter;
    }
}

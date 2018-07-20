package com.example.demo.property;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoProperty {

    @Value("${udp.title}")
    private String title;

    @Value("${udp.description}")
    private String description;
}

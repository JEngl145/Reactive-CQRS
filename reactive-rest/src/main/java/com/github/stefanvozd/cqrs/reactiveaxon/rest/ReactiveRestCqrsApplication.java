package com.github.stefanvozd.cqrs.reactiveaxon.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.github.stefanvozd.cqrs.reactiveaxon")
@SpringBootApplication
public class ReactiveRestCqrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRestCqrsApplication.class, args);
    }


}
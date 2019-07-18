package com.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public abstract class SampleMapperApplication implements CommandLineRunner {
	public static void main(String[] args) {
        SpringApplication.run(SampleMapperApplication.class, args);   
    }
}

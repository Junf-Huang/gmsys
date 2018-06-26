package com.exercise.gmsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GmsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmsysApplication.class, args);
	}
}

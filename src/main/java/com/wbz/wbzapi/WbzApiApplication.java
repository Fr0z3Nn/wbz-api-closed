package com.wbz.wbzapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:const.properties")

public class WbzApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WbzApiApplication.class, args);
	}

}

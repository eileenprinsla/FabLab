package com.FabLab.FabLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.FabLab.FabLab"})
public class FabLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabLabApplication.class, args);
	}

}

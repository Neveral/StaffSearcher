package com.solanteq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class StaffManagerApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(StaffManagerApplication.class, args);
		}catch(Exception ex){
			System.err.println(ex.getMessage());
		}
	}
}

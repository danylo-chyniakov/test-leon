package com.parsing.leon;

import com.parsing.leon.config.FeignConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@Import(FeignConfiguration.class)
public class LeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeonApplication.class, args);
	}

}

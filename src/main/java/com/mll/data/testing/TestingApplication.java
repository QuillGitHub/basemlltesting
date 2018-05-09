package com.mll.data.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.mll.data.testing.*.mapper")
@EnableSwagger2
public class TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
	}
}

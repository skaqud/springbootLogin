package com.springboot.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.itsbox"})
@MapperScan({"com.itsbox"})
@PropertySource("classpath:application.properties")
@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication app =
                new SpringApplication(LoginApplication.class);
//        Properties properties = new Properties();
//        properties.setProperty("spring.resources.static-locations", "classpath:/static/view/dist/");
//        app.setDefaultProperties(properties);
        app.run(args);
	}
}


package com.springboot.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.springboot"})
@MapperScan({"com.springboot.auth"})
@PropertySource("classpath:application.properties")
@SpringBootApplication
@SpringBootTest
public class LoginApplicationTests {

	@Test
	public void contextLoads() {
	}

}

package com.hcrh.hibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.hcrh.hibernatedemo.service",
		"com.hcrh.hibernatedemo.dao"})
@EntityScan(basePackages = {"com.hcrh.hibernatedemo.entity"})//扫描实体包
@EnableJpaRepositories//开启jpa的注解
public class AaaApplication {
	private static  Logger log = LoggerFactory.getLogger(AaaApplication.class);
 	public static void main(String[] args) {
 		log.info("springdemo-hibernate-启动----------------------------");
		SpringApplication.run(AaaApplication.class, args);
	}
}

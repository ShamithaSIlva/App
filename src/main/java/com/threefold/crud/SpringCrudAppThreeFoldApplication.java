package com.threefold.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.mongobee.Mongobee;

@SpringBootApplication()
public class SpringCrudAppThreeFoldApplication {
	
//	@Bean
//	public Mongobee mongoTemplate() {
//		Mongobee runner = new Mongobee("mongodb://threefolddb:27017/Customer");
//		runner.setDbName("Customer");
//		runner.setChangeLogsScanPackage("com.threefold.crud");
//
//		return runner;
//	}
	
//	exclude = {
//			  MongoAutoConfiguration.class, 
//			  MongoDataAutoConfiguration.class
			

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudAppThreeFoldApplication.class, args);
	}

}

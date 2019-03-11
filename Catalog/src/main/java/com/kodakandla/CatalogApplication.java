package com.kodakandla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//if this class is in a different package (com.kodakandla.config for example), then only that particular package and its sub packages
//are scanned by Spring boot... any other classes outside of that packages will not be scanned.. in that scenario, we need to provide
//the following two annotations..

//@ComponentScan("com.kodakandla")//
//@EnableJpaRepositories(basePackages="com.kodakandla") //this is essential... by default SpringBoot wouldn't be able to autowire JPA repositories.
@SpringBootApplication
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

}

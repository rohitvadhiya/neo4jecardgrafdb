package com.neo4j.ecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@ComponentScan
@EnableAutoConfiguration
@EntityScan("com.neo4j.ecard.entity")
@EnableNeo4jRepositories("com.neo4j.ecard.repo")
@SpringBootApplication
public class EcardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcardApplication.class, args);
	}

}

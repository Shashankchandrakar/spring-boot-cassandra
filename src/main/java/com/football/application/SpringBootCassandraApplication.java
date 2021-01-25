package com.football.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.football")
@EntityScan(basePackages = "com.football")
@EnableCassandraRepositories(basePackages = "com.football")
public class SpringBootCassandraApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCassandraApplication.class, args);
    }
}

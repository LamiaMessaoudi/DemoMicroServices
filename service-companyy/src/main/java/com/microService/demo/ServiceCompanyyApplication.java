package com.microService.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.microService.ServiceImpl.CompanyServiceImpl;
import com.microService.entities.Company;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("com.microService.Repository")
@ComponentScan({"com.microService.Controller","com.microService.Service","com.microService.ServiceImpl"})
@EntityScan(basePackages = "com.microService.entities")
@EnableAutoConfiguration
public class ServiceCompanyyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyyApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompanyServiceImpl companyServiceImpl)
	{
		return args->{
			Stream.of("A","B","C").forEach(cn->{
				companyServiceImpl.saveCompany(new Company(null,cn,Math.random()*9000));
			});
			companyServiceImpl.findAllCompany().forEach(System.out::println);
		};
	}

}

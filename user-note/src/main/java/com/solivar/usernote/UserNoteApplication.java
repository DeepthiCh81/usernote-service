package com.solivar.usernote;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.solivar"})
@EntityScan(basePackages = {"com.solivar"})
@EnableJpaRepositories(basePackages = {"com.solivar"})
@SpringBootApplication
public class UserNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserNoteApplication.class, args);
	}
	
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }

}

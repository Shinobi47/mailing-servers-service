package com.benayed.mailing.servers;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@SpringBootApplication
public class ServersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersServiceApplication.class, args);
	}

	@Bean
	@Primary
    public ObjectMapper buildObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.registerModule(new SimpleModule().addSerializer(LocalDateTime.class, LocalDateTimeSerializer.INSTANCE));
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper;
    }
}

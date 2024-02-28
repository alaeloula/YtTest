package com.example.yttest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperconf{
    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
}
package ru.yamshikov.rest.api.projectthree.config.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDto {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

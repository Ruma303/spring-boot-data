package com.example.demo.configs;

import com.example.demo.converters.DateConverter;
import com.example.demo.converters.TrimStringConverter;
import com.example.demo.converters.EnumConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(true);

        modelMapper.addConverter(TrimStringConverter.trimConverter);
        modelMapper.addConverter(DateConverter.localDateToString);
        modelMapper.addConverter(DateConverter.stringToLocalDate);
        modelMapper.addConverter(EnumConverter.enumToString);
        modelMapper.addConverter(EnumConverter.stringToEnum);

        return modelMapper;
    }
}
package com.example.demo.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class TrimStringConverter {

    public static final Converter<String, String> trimConverter = new Converter<>() {
        @Override
        public String convert(MappingContext<String, String> context) {
            return context.getSource() == null ? "" : context.getSource().trim();
        }
    };
}
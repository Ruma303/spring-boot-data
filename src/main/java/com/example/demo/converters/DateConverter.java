package com.example.demo.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final Converter<LocalDate, String> localDateToString = new Converter<>() {
        @Override
        public String convert(MappingContext<LocalDate, String> context) {
            LocalDate source = context.getSource();
            return source == null ? "" : source.format(formatter);
        }
    };

    public static final Converter<String, LocalDate> stringToLocalDate = new Converter<>() {
        @Override
        public LocalDate convert(MappingContext<String, LocalDate> context) {
            String source = context.getSource();
            return source == null || source.isBlank() ? null : LocalDate.parse(source, formatter);
        }
    };
}

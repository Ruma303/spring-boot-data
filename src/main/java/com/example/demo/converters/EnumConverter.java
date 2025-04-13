package com.example.demo.converters;

import com.example.demo.entities.StudentStatus;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class EnumConverter {

    public static final Converter<StudentStatus, String> enumToString = new Converter<>() {
        @Override
        public String convert(MappingContext<StudentStatus, String> context) {
            StudentStatus source = context.getSource();
            return source == null ? "UNKNOWN" : source.name();
        }
    };

    public static final Converter<String, StudentStatus> stringToEnum = new Converter<>() {
        @Override
        public StudentStatus convert(MappingContext<String, StudentStatus> context) {
            return StudentStatus.fromString(context.getSource());
        }
    };
}
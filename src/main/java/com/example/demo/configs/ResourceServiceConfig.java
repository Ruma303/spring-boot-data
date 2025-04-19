package com.example.demo.configs;

import com.example.demo.models.Text;
import com.example.demo.models.Video;
import com.example.demo.models.File;
import com.example.demo.repositories.ResourceRepository;
import com.example.demo.services.ResourceService;
import com.example.demo.services.ResourceServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceServiceConfig {

    @Bean
    public ResourceService<Text> textResourceService(ResourceRepository repository, EntityManager em) {
        return new ResourceServiceImpl<>(repository, em, Text.class);
    }

    @Bean
    public ResourceService<Video> videoResourceService(ResourceRepository repository, EntityManager em) {
        return new ResourceServiceImpl<>(repository, em, Video.class);
    }

    @Bean
    public ResourceService<File> fileResourceService(ResourceRepository repository, EntityManager em) {
        return new ResourceServiceImpl<>(repository, em, File.class);
    }
}

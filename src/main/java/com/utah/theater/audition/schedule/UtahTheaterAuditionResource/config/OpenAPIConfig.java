package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi utahTheaterAuditionsOpenAPI() {
        return GroupedOpenApi.builder()
                .group("Utah Theater Auditions API")
                .packagesToScan("com.utah.theater.audition.schedule.UtahTheaterAuditionResource.apis")
                .build();
    }
}

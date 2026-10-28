package com.kairos.midelware.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiValues {
    @Value("${application.api.uri.title}")
    private String title;
    @Value("${application.api.uri.version}")
    private String version;

    @Value("${application.api.uri.description}")
    private String description;

    @Value("${application.api.server.url}")
    private String urlServer;


}

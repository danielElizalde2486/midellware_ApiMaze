package com.kairos.midelware.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "shows")
public class Show {
    @Id
    private Long id;
    private String name;
    private String type;
    private String summary;
    private WebChannel webChannel;
    private List<String> genres;
    @Transient
    private List<CommentsPerformance> comments;

    @Data
    public static class WebChannel {
        private Long id;
        private String name;
        private Country country;
        private String officialSite;
    }

    @Data
    public static class Country {
        private String name;
        private String code;
        private String timezone;
    }
}

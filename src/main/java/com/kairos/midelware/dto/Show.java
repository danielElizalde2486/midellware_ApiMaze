package com.kairos.midelware.dto;

import lombok.Data;

import java.util.List;

@Data
public class Show {
    private Long id;
    private String name;
    private String type;
    private String summary;
    private WebChannel webChannel;
    private List<String> genres;

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

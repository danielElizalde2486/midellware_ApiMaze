package com.kairos.midelware.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private Long showId;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;
}

package com.kairos.midelware.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommentsPerformance {
    private String comment;
    private Integer rating;
}

package com.kairos.midelware.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {
    @NotNull(message = "El campo showId no debe de ir vacio")
    private Long showId;

    @NotBlank(message = "El campo comment no debe de ir vacio")
    private String comment;

    @NotNull(message = "El campo rating no debe de ir vacio")
    private Integer rating;
}

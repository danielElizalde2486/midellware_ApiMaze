package com.kairos.midelware.exception;

import com.kairos.midelware.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse resolveInvalidOtpException(
            final HttpServletRequest req,
            final IllegalArgumentException ex
    ) {
        log.error("Error", ex);
        return ErrorResponse.builder()
                .code("Error controlado")
                .details(ex
                        .getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {


        StringBuilder errors = new StringBuilder();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.append(fieldName+":"+errorMessage+",");
        });

        ErrorResponse error = ErrorResponse.builder()
                .code("0001-Persoalizable")
                .details(errors.toString())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.badRequest().body(error);
    }
}

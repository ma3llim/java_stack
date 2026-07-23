package org.products.Dtos.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private T data;
    @Builder.Default
    private List<String> errors = null;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private String path;

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String message, List<String> errors, String path) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .errors(errors)
                .path(path)
                .build();
    }
}


package com.sameer.question_service.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class quizResponse {
    private Integer id;
    private String response;
}

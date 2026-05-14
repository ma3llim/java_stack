package com.sameer.quiz_service.models;

import lombok.Data;

@Data
public class QuizDto {
    private String category;
    private Integer numQuestions;
    private String title;

}

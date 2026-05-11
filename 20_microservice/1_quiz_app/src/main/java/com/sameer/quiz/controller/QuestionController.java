package com.sameer.quiz.controller;

import com.sameer.quiz.models.Question;
import com.sameer.quiz.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    QuestionServices questionServices;

    @GetMapping("/allquestions")
    public List<Question> getAllQuestion(){
        return questionServices.getAllQuestions();
    }
}

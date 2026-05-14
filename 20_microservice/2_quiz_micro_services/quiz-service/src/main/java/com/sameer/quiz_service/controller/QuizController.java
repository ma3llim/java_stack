package com.sameer.quiz_service.controller;

import com.sameer.quiz_service.models.QuestionWrapper;
import com.sameer.quiz_service.models.QuizDto;
import com.sameer.quiz_service.services.QuizServices;
import com.sameer.quiz_service.models.quizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizServices.createQuiz(quizDto.getCategory(), quizDto.getNumQuestions(), quizDto.getTitle());
    }

//    @GetMapping("/getquiz/{quizId}")
//    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId){
//        return quizServices.getQuizQuestions(quizId);
//    }
//
//    @PostMapping("/submit/{id}")
//    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<quizResponse> responses){
//        return quizServices.calculateResult(id, responses);
//    }
}

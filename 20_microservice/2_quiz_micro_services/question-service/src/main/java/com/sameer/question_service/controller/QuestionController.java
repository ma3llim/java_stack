package com.sameer.question_service.controller;

import com.sameer.question_service.models.Question;
import com.sameer.question_service.models.QuestionWrapper;
import com.sameer.question_service.models.quizResponse;
import com.sameer.question_service.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    QuestionServices questionServices;

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionServices.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionServices.getQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionServices.addQuestion(question);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer questionId){
        return questionServices.deleteQuestion(questionId);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numOfQuestion){
        return questionServices.getQuestionsForQuiz(categoryName, numOfQuestion);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
         return questionServices.getQuestionFromId(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<quizResponse> responses){
        return questionServices.getScore(responses);
    }
}

package com.sameer.quiz.services;

import com.sameer.quiz.dao.QuestionDao;
import com.sameer.quiz.models.Question;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServices {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer questionId) {
        try {
            questionDao.deleteById(questionId);
            return new ResponseEntity<>("Question Deleted Successfully", HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Something Went Wrong", HttpStatus.BAD_REQUEST);
    }
}

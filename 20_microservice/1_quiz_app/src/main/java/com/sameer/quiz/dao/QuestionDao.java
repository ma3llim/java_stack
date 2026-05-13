package com.sameer.quiz.dao;

import com.sameer.quiz.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(
            value = "SELECT * FROM question q WHERE LOWER(q.category)=LOWER(:category) ORDER BY RANDOM() LIMIT :noOfQuestions",
            nativeQuery = true
    )
    List<Question> findRandomQuestionByCategory(
            @Param("category") String category,
            @Param("noOfQuestions") int noOfQuestions
    );

    List<Question> findByCategory(String category);
}
package com.sameer.question_service.dao;

import com.sameer.question_service.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT q.id FROM question q WHERE LOWER(q.category)=LOWER(:category) ORDER BY RANDOM() LIMIT :noOfQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int noOfQuestions);

    List<Question> findByCategory(String category);
}
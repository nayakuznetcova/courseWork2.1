package com.example.coursWork21.service;

import com.example.coursWork21.exceptions.FewQuestionsException;
import com.example.coursWork21.storage.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getRandomQuestions(int num) {
        if(questionService.getAll().size()<num){
            throw new FewQuestionsException("Запрошено большее количество вопросов, чем имеется");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < num) {
            Question randomQuestions = questionService.getRandomQuestion();
            questions.add(randomQuestions);
        }
        return questions;
    }
}

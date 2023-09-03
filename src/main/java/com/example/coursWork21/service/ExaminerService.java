package com.example.coursWork21.service;

import com.example.coursWork21.storage.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getRandomQuestions(int num);

}

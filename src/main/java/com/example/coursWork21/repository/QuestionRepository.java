package com.example.coursWork21.repository;

import com.example.coursWork21.storage.Question;

import java.util.Collection;

public interface QuestionRepository {
    boolean add(Question e);
    boolean remove(Question e);
    Collection<Question> getAll();
}

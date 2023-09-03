package com.example.coursWork21.repository;

import com.example.coursWork21.storage.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{
    private Set<Question> questions = new HashSet<>();

    @Override
    public boolean add(Question e) {
        return questions.add(e);
    }

    @Override
    public boolean remove(Question e) {
        return questions.remove(e);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}

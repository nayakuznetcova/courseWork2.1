package com.example.coursWork21.controller;

import com.example.coursWork21.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java/random")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
@GetMapping
    public String getRandomQuestions(@RequestParam int num){
        return "random list: " + examinerService.getRandomQuestions(num);
    }
}

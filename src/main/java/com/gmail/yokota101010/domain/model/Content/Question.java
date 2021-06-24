package com.gmail.yokota101010.domain.model.Content;

import java.util.UUID;

public class Question {
    public String id;
    public String question;
    public String answer;
    public Status st = Status.Open;

    public Question(String question,String answer,Status st){
        this.id = UUID.randomUUID().toString();;
        this.question = question;
        this.answer = answer;
        this.st = st;
    }
}

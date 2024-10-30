package com.aecode.webcoursesback.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sessionanswers")
@SequenceGenerator(name = "sessionans_seq", sequenceName = "sessionans_sequence", allocationSize = 1)

public class SessionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessionans_seq")
    private int answerId;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private SessionTest sessiontest;

    @Column(nullable = false, length = 255)
    private String answerText;

    @Column(nullable = false)
    private boolean isCorrect;

    public SessionAnswer() {
    }

    public SessionAnswer(int answerId, SessionTest sessiontest, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.sessiontest = sessiontest;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public SessionTest getSessiontest() {
        return sessiontest;
    }

    public void setSessiontest(SessionTest sessiontest) {
        this.sessiontest = sessiontest;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

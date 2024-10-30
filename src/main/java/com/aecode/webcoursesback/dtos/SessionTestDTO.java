package com.aecode.webcoursesback.dtos;
import java.util.List;

public class SessionTestDTO {
    private int testId;
    private int sessionId;
    private String questionText;
    private List<SessionAnswerDTO> sessionanswers;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<SessionAnswerDTO> getSessionanswers() {
        return sessionanswers;
    }

    public void setSessionanswers(List<SessionAnswerDTO> sessionanswers) {
        this.sessionanswers = sessionanswers;
    }
}

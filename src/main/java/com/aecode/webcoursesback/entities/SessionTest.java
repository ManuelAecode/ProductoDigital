package com.aecode.webcoursesback.entities;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sessiontests")
@SequenceGenerator(name = "sessiontest_seq", sequenceName = "sessiontest_sequence", allocationSize = 1)
public class SessionTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sessiontest_seq")
    private int testId;

    @OneToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String questionText;

    @OneToMany(mappedBy = "sessiontest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SessionAnswer> sessionanswers =  new ArrayList<>();


    public SessionTest() {
    }


    public SessionTest(int testId, Session session, String questionText, List<SessionAnswer> sessionanswers) {
        this.testId = testId;
        this.session = session;
        this.questionText = questionText;
        this.sessionanswers = sessionanswers;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<SessionAnswer> getSessionanswers() {
        return sessionanswers;
    }

    public void setSessionanswers(List<SessionAnswer> sessionanswers) {
        this.sessionanswers = sessionanswers;
    }
}

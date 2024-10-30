package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.SessionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISessionAnswerRepo extends JpaRepository<SessionAnswer,Integer> {
}

package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.UserProgressSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProgressSessionRepo extends JpaRepository<UserProgressSession, Integer> {
}

package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.UserCourseAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCourseRepo extends JpaRepository<UserCourseAccess, Integer> {
}

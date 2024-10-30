package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISessionRepo extends JpaRepository<Session,Integer> {
    @Query("SELECT s FROM Session s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Session> searchByTitle(@Param("title") String title);

}

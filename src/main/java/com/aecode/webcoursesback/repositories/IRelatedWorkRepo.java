package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.RelatedWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRelatedWorkRepo extends JpaRepository<RelatedWork,Integer> {
}

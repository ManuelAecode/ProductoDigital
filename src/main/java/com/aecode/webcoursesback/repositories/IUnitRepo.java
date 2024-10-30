package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitRepo extends JpaRepository<Unit,Integer> {
}

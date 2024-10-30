package com.aecode.webcoursesback.repositories;

import com.aecode.webcoursesback.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleRepo extends JpaRepository<Module,Integer> {
}

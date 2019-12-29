package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandLineRepesitory extends JpaRepository<CommandLineEntity, String> {
}

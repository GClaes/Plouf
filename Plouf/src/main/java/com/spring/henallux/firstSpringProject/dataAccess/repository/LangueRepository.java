package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LangueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LangueRepository extends JpaRepository<LangueEntity, String> {
}

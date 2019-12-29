package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LangueEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TraductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraductionRepository extends JpaRepository<TraductionEntity, Integer> {
    TraductionEntity findByLangueAndProduit(LangueEntity langue, ProductEntity product);
}

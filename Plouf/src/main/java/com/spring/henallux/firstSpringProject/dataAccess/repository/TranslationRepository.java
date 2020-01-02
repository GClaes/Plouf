package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    TranslationEntity findByLangueAndProduit(LanguageEntity langue, ProductEntity product);
}

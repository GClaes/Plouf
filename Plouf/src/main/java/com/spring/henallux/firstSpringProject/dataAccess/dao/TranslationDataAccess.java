package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Translation;

public interface TranslationDataAccess {
    Translation findTraduction(String langueCode, Integer idProduit);
}

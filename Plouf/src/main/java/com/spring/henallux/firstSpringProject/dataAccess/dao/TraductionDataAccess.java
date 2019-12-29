package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TraductionEntity;
import com.spring.henallux.firstSpringProject.model.Traduction;

public interface TraductionDataAccess {
    Traduction findTraduction(String langueCode, Integer idProduit);
}

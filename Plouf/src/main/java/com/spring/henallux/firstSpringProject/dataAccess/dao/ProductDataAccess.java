package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Product;

import java.util.List;

public interface ProductDataAccess {
    List<Product> findAll(String codeLangue);
}

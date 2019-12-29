package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LangueEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TraductionEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LangueRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TraductionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductDataAccess {
    private final ProductRepository productRepository;
    private final TraductionRepository traductionRepository;
    private final LangueRepository langueRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public ProductDAO(ProductRepository productRepository, TraductionRepository traductionRepository, LangueRepository langueRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.traductionRepository = traductionRepository;
        this.langueRepository = langueRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public List<Product> findAll(String codeLangue) {
        List<ProductEntity>produitEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for(ProductEntity productEntity :produitEntities) {
            LangueEntity langue = langueRepository.getOne(codeLangue);
            TraductionEntity traduction = traductionRepository.findByLangueAndProduit(langue,productEntity);
            products.add(providerConverter.produitEntityToProduitModel(productEntity, traduction));
        }

        return products;
    }
}

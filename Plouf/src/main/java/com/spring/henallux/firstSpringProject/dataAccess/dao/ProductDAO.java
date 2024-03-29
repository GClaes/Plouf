package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAO implements ProductDataAccess {
    private final ProductRepository productRepository;
    private final TranslationRepository translationRepository;
    private final LanguageRepository languageRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public ProductDAO(ProductRepository productRepository, TranslationRepository translationRepository, LanguageRepository languageRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.translationRepository = translationRepository;
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public List<Product> findAll(String codeLangue) {
        List<ProductEntity>produitEntities = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        for(ProductEntity productEntity :produitEntities) {
            LanguageEntity langue = languageRepository.getOne(codeLangue);
            TranslationEntity traduction = translationRepository.findByLangueAndProduit(langue,productEntity);
            products.add(providerConverter.produitEntityToProduitModel(productEntity, traduction));
        }

        return products;
    }
}

package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationDAO implements TranslationDataAccess {

    private  final TranslationRepository translationRepository;
    private final ProductRepository productRepository;
    private final LanguageRepository languageRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProductRepository productRepository, LanguageRepository languageRepository, ProviderConverter providerConverter) {
        this.translationRepository = translationRepository;
        this.productRepository = productRepository;
        this.languageRepository = languageRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Translation findTraduction(String langueCode, Integer idProduit) {
        LanguageEntity langue = languageRepository.getOne(langueCode);
                //findById(langueCode).orElseThrow(()->new RuntimeException("Langue Inexistante : "+langueCode));
        ProductEntity produit = productRepository.getOne(idProduit);
                //findById(idProduit).orElseThrow(()->new RuntimeException("Produit non trouvé :"+idProduit));
        TranslationEntity traduction = translationRepository.findByLangueAndProduit(langue, produit);

        return providerConverter.traductionEntityToTraductionModel(traduction);
    }
}

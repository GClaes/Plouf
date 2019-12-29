package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LangueEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TraductionEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LangueRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TraductionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Traduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraductionDAO implements TraductionDataAccess {

    private  final TraductionRepository traductionRepository;
    private final ProductRepository productRepository;
    private final LangueRepository langueRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public TraductionDAO(TraductionRepository traductionRepository, ProductRepository productRepository, LangueRepository langueRepository, ProviderConverter providerConverter) {
        this.traductionRepository = traductionRepository;
        this.productRepository = productRepository;
        this.langueRepository = langueRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Traduction findTraduction(String langueCode, Integer idProduit) {
        LangueEntity langue = langueRepository.getOne(langueCode);
                //findById(langueCode).orElseThrow(()->new RuntimeException("Langue Inexistante : "+langueCode));
        ProductEntity produit = productRepository.getOne(idProduit);
                //findById(idProduit).orElseThrow(()->new RuntimeException("Produit non trouvé :"+idProduit));
        TraductionEntity traduction = traductionRepository.findByLangueAndProduit(langue, produit);

        return providerConverter.traductionEntityToTraductionModel(traduction);
    }
}

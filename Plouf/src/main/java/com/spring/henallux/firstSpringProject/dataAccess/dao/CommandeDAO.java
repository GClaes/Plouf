package com.spring.henallux.firstSpringProject.dataAccess.dao;


import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandeEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CommandeRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeDAO implements  CommandeDataAccess{
    private final CommandeRepository commandeRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public CommandeDAO(CommandeRepository commandeRepository, ProviderConverter providerConverter) {
        this.commandeRepository = commandeRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Commande save(Commande commande) {
        CommandeEntity commandeEntity = providerConverter.commandeModelToCommandeEntity(commande);
        commandeRepository.save(commandeEntity);
        return commande;
    }
}

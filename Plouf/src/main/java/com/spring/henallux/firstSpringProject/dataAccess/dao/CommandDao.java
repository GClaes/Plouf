package com.spring.henallux.firstSpringProject.dataAccess.dao;


import com.spring.henallux.firstSpringProject.dataAccess.entity.CommandEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.CommandRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandDao implements CommandDataAccess {
    private final CommandRepository commandRepository;
    private final ProviderConverter providerConverter;


    @Autowired
    public CommandDao(CommandRepository commandRepository, ProviderConverter providerConverter) {
        this.commandRepository = commandRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Command save(Command command) {
        CommandEntity commandEntity = providerConverter.commandeModelToCommandeEntity(command);
        commandRepository.save(commandEntity);
        return command;
    }
}

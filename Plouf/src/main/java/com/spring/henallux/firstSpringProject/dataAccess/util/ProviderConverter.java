package com.spring.henallux.firstSpringProject.dataAccess.util;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderConverter {


    public List<User> userListEntitiesToUserListModel(List<UserEntity> userEntities){
        List<User>users = new ArrayList<>();
        for(UserEntity userEntity : userEntities){
            users.add(userEntityToUserModel(userEntity));
        }
        return users;
    }
    public UserEntity userModelToUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(user.getUsername());
        userEntity.setMotDePasse(new BCryptPasswordEncoder().encode(user.getPassword()));
        userEntity.setNom(user.getNom());
        userEntity.setPrenom(user.getPrenom());
        if(user.getNumTel() !=null)
            userEntity.setNumTel(user.getNumTel());
        userEntity.setEmail(user.getEmail());
        userEntity.setRue(user.getRue());
        userEntity.setLocalite(user.getLocalite());
        userEntity.setCodePostal(user.getCodePostal());
        userEntity.setNumRue(user.getNumRue());
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setRoles(user.getStringAuthority());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());


        return userEntity;
    }
    public User userEntityToUserModel(UserEntity userEntity){
        if(userEntity == null){
         return null;
        }
        User user = new User();
        user.setLogin(userEntity.getLogin());
        user.setMotDePasse(userEntity.getMotDePasse());
        user.setNom(userEntity.getNom());
        user.setPrenom(userEntity.getPrenom());
        if(userEntity.getNumTel() != null)
            user.setNumTel(userEntity.getNumTel());
        user.setEmail(userEntity.getEmail());
        user.setRue(userEntity.getRue());
        user.setLocalite(userEntity.getLocalite());
        user.setCodePostal(userEntity.getCodePostal());
        user.setNumRue(userEntity.getNumRue());

        user.setEnabled(userEntity.isEnabled());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        user.setRoles(userEntity.getRoles());

        return user;
    }

    public ProductEntity produitModelToProduitEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setNom(product.getNom());
        productEntity.setNumProduit(product.getNumProduit());
        productEntity.setPrixcatalogue(product.getPrixcatalogue());
        productEntity.setTvaappliquee(product.getTvaappliquee());
        productEntity.setUrlImg(product.getUrlImg());
        return productEntity;
    }

    public Product produitEntityToProduitModel(ProductEntity productEntity, TranslationEntity translationEntity){
        Product product = new Product();
        product.setNom(translationEntity.getNomProduit());
        product.setNumProduit(productEntity.getNumProduit());
        product.setPrixcatalogue(productEntity.getPrixcatalogue());
        product.setTvaappliquee(productEntity.getTvaappliquee());
        product.setUrlImg(productEntity.getUrlImg());
        product.setDescription(translationEntity.getDescription());
        return product;
    }

    public Command commandeEntityToCommandeModel(CommandEntity commandEntity){
        Command command = new Command();
        command.setDateCommande(commandEntity.getDatecommande());
        return command;
    }

    public CommandEntity commandeModelToCommandeEntity(Command command){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CommandEntity commandEntity = new CommandEntity(command.getDateCommande(), userModelToUserEntity(user));
        for(CommandLine commandLine : command.getLignes()){
            CommandLineEntity commandLineEntity = new CommandLineEntity(commandLine.getQuantite(), commandLine.getPrix(), commandEntity,productModelToProductEntity(commandLine.getProduit()));
            commandEntity.addLine(commandLineEntity);
        }
        return commandEntity;
    }

    public ProductEntity productModelToProductEntity(Product product){
        return new ProductEntity(product.getNumProduit(), product.getNom(), product.getPrixcatalogue(), product.getTvaappliquee());
    }

    public Translation traductionEntityToTraductionModel(TranslationEntity translationEntity){
        return new Translation(translationEntity.getNomProduit(), translationEntity.getDescription());
    }
}

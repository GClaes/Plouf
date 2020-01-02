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

    public Product produitEntityToProduitModel(ProductEntity productEntity, TraductionEntity traductionEntity){
        Product product = new Product();
        product.setNom(traductionEntity.getNomProduit());
        product.setNumProduit(productEntity.getNumProduit());
        product.setPrixcatalogue(productEntity.getPrixcatalogue());
        product.setTvaappliquee(productEntity.getTvaappliquee());
        product.setUrlImg(productEntity.getUrlImg());
        product.setDescription(traductionEntity.getDescription());
        return product;
    }

    public Commande commandeEntityToCommandeModel(CommandeEntity commandeEntity){
        Commande commande = new Commande();
        commande.setDateCommande(commandeEntity.getDatecommande());
        return commande;
    }

    public CommandeEntity commandeModelToCommandeEntity(Commande commande){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CommandeEntity commandeEntity = new CommandeEntity(commande.getDateCommande(), userModelToUserEntity(user));
        for(CommandLine commandLine : commande.getLignes()){
            CommandLineEntity commandLineEntity = new CommandLineEntity(commandLine.getQuantite(), commandLine.getPrix(),commandeEntity,productModelToProductEntity(commandLine.getProduit()));
            commandeEntity.addLine(commandLineEntity);
        }
        return  commandeEntity;
    }

    public ProductEntity productModelToProductEntity(Product product){
        return new ProductEntity(product.getNumProduit(), product.getNom(), product.getPrixcatalogue(), product.getTvaappliquee());
    }

    public Traduction traductionEntityToTraductionModel(TraductionEntity traductionEntity){
        return new Traduction(traductionEntity.getNomProduit(), traductionEntity.getDescription());
    }
}

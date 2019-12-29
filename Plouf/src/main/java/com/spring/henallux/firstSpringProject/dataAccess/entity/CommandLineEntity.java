package com.spring.henallux.firstSpringProject.dataAccess.entity;


import com.spring.henallux.firstSpringProject.model.Commande;

import javax.persistence.*;

@Entity
@Table(name="lignecommande")
public class CommandLineEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="quantite")
    private float quantity;

    @Column(name="prix")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "commandeid")
    private CommandeEntity commandeEntity;

    @ManyToOne
    @JoinColumn(name="produitid")
    private ProductEntity productEntity;

    public CommandLineEntity(float quantity, float prix, CommandeEntity commandeEntity, ProductEntity productEntity) {
        this.quantity = quantity;
        this.prix = prix;
        this.commandeEntity = commandeEntity;
        this.productEntity = productEntity;
    }

    public CommandLineEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public CommandeEntity getCommandeEntity() {
        return commandeEntity;
    }

    public void setCommandeEntity(CommandeEntity commandeEntity) {
        this.commandeEntity = commandeEntity;
    }


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}

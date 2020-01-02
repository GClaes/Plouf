package com.spring.henallux.firstSpringProject.dataAccess.entity;


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
    private CommandEntity commandEntity;

    @ManyToOne
    @JoinColumn(name="produitid")
    private ProductEntity productEntity;

    public CommandLineEntity(float quantity, float prix, CommandEntity commandEntity, ProductEntity productEntity) {
        this.quantity = quantity;
        this.prix = prix;
        this.commandEntity = commandEntity;
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

    public CommandEntity getCommandEntity() {
        return commandEntity;
    }

    public void setCommandEntity(CommandEntity commandEntity) {
        this.commandEntity = commandEntity;
    }


    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}

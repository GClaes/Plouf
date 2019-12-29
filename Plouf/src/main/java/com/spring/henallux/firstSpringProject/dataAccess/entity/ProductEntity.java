package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produit")
public class ProductEntity {
    @Id @Column(name="numproduit")
    private Integer numProduit;

    @Column (name="nom")
    private String nom;

    @Column (name="prixcatalogue")
    private float prixcatalogue;

    @Column (name="tvaappliquee")
    private float tvaappliquee;

    @Column (name="urlimg")
    private String urlImg;




    public ProductEntity(int numProduit, String nom, float prixcatalogue, float tvaappliquee) {
        this.numProduit = numProduit;
        this.nom = nom;
        this.prixcatalogue = prixcatalogue;
        this.tvaappliquee = tvaappliquee;
    }

    public ProductEntity() {
    }

    public int getNumProduit() {
        return numProduit;
    }

    public void setNumProduit(int numProduit) {
        this.numProduit = numProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixcatalogue() {
        return prixcatalogue;
    }

    public void setPrixcatalogue(float prixcatalogue) {
        this.prixcatalogue = prixcatalogue;
    }

    public float getTvaappliquee() {
        return tvaappliquee;
    }

    public void setTvaappliquee(float tvaappliquee) {
        this.tvaappliquee = tvaappliquee;
    }
    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

}


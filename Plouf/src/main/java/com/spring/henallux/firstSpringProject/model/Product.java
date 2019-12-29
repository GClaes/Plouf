package com.spring.henallux.firstSpringProject.model;

public class Product {
    private int numProduit;
    private String nom;
    private String description;
    private float prixcatalogue;
    private float tvaappliquee;
    private String urlImg;


    public Product() {
    }

    @Override
    public boolean equals(Object obj) {
        Product p = (Product)obj;
        return this.numProduit == p.getNumProduit();
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

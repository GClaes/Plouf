package com.spring.henallux.firstSpringProject.model;

public class Traduction {
    public String nomProduit;
    public String description;

    public Traduction(String nomProduit, String description) {
        this.nomProduit = nomProduit;
        this.description = description;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

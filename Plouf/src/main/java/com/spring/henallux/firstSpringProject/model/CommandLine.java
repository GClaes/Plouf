package com.spring.henallux.firstSpringProject.model;

public class CommandLine {
    private int quantite;
    private float prix;
    private Product produit;

    public CommandLine(int quantite, float prix, Product produit) {
        this.quantite = quantite;
        this.prix = prix;
        this.produit = produit;
    }

    public CommandLine() {
    }

    public Product getProduit() {
        return produit;
    }

    public void addQuantite(){
        quantite++;
    }
    public void rmQuantite(){
        if(quantite > 1)
            quantite--;
    }

    @Override
    public boolean equals(Object obj) {
        CommandLine c = (CommandLine)obj;
        return this.produit.equals(c.getProduit());
    }

    public void setProduit(Product produit) {
        this.produit = produit;
    }


    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}

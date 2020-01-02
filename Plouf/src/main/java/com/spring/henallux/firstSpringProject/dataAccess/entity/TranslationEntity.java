package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "traduction")
public class TranslationEntity {
    @Id @Column(name = "id")
    private Integer id;

    @Column (name = "nom")
    private String nomProduit;

    @Column (name = "descrip")
    private String description;

    @ManyToOne
    @JoinColumn (name = "numproduit")
    private ProductEntity produit;

    @ManyToOne
    @JoinColumn(name="langueid")
    private LanguageEntity langue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ProductEntity getProduit() {
        return produit;
    }

    public void setProduit(ProductEntity produit) {
        this.produit = produit;
    }

    public LanguageEntity getLangue() {
        return langue;
    }

    public void setLangue(LanguageEntity langue) {
        this.langue = langue;
    }
}

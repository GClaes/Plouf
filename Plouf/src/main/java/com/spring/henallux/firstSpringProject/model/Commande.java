package com.spring.henallux.firstSpringProject.model;

import java.util.Date;
import java.util.List;

public class Commande {
    private List<CommandLine> lignes;
    private Date dateCommande;


    public Commande(List<CommandLine> lignes, Date dateCommande) {
        this.lignes = lignes;
        this.dateCommande = dateCommande;
    }

    public Commande() {
    }

    public List<CommandLine> getLignes() {
        return lignes;
    }

    public void setLignes(List<CommandLine> lignes) {
        this.lignes = lignes;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
}

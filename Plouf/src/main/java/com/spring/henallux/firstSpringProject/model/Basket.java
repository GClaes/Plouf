package com.spring.henallux.firstSpringProject.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private List<CommandLine> lines = new ArrayList<>();

    public void addProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product ne peut pas etre null");
        }
        CommandLine commandLine = new CommandLine(1, product.getPrixcatalogue(), product);
        if (!lines.contains(commandLine))
            lines.add(commandLine);
    }

    public void removeProduct(Product product) {
        if(product == null)
            return;
        Integer index = null;
        for (CommandLine c : lines) {
            if (c.getProduit().getNumProduit() == product.getNumProduit()) {
                index = lines.indexOf(c);
            }
        }
        if(index != null)
            lines.remove(lines.get(index));
    }

    public void rmQuantite(Product product) {
        if(product == null){
            return;
        }
        for (CommandLine c : lines) {
            if (c.getProduit().getNumProduit() == product.getNumProduit()) {
                c.rmQuantite();
            }
        }
    }

    public void addQuantite(Product product){
        if(product == null){
            return;
        }
        for(CommandLine c :this.getLines()){
            if (c.getProduit().getNumProduit() == product.getNumProduit()) {
                c.addQuantite();
            }
        }
    }

    public List<CommandLine> getLines() {
       // return Collections.unmodifiableList(lines);
        return lines;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(CommandLine c: lines){
            totalPrice += c.getPrix()*(1+c.getProduit().getTvaappliquee())*c.getQuantite();
        }
        return  totalPrice;
    }

    public void clean(){
        lines = new ArrayList<>();
    }
}

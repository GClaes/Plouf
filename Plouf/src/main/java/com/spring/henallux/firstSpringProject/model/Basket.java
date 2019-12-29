package com.spring.henallux.firstSpringProject.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<CommandLine> lines = new ArrayList<>();

    public void addProduct(Product product) {
        CommandLine commandLine = new CommandLine(1, product.getPrixcatalogue(), product);
        if (!lines.contains(commandLine))
            lines.add(commandLine);
    }

    public void removeProduct(CommandLine commandLine) {
        lines.remove(commandLine);
    }

    public void rmQuantite(CommandLine commandLine) {
        for (CommandLine c : lines) {
            if (c == commandLine) {
                c.rmQuantite();
            }
        }
    }

    public void addQuantite(CommandLine commandLine){
        for(CommandLine c :this.getLines()){
            if (c == commandLine) {
                c.addQuantite();
            }
        }
    }

    public List<CommandLine> getLines() {
        return lines;
    }

    public void setLines(List<CommandLine> lines) {
        this.lines = lines;
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

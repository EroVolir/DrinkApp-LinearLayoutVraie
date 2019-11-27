package com.example.android.coffeeapp;

public class Drink extends Order {

    private String nom;
    private String type;
    private String options;

    public Drink (double price, String untype, String uneOptions){

        super(price);
        this.type = untype;
        this.options = uneOptions;

    }
}

package com.example.android.coffeeapp;

public class Options extends Drink {

    private String name;
    private double price;

    public Options (double price, String unType, String uneOptions, String unNom, double unPrix){

        super(price, unType, uneOptions);
        this.name = unNom;
        this.price = unPrix;

    }
}

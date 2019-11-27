package com.example.android.coffeeapp;

public class Order {

    private double price;
    private int numberOfDrink;
    private double priceType;
    private double priceOptions;


    public Order(double price){
        if(price >0){
            this.price = price;
        }
        else
            this.price = 0;
        this.numberOfDrink = 0;
        this.priceType = 0;
        this.priceOptions = 0;

    }
    public String orderResult(){
        String resultat = "";
        resultat =+ this.numberOfDrink + " boisson au prix de " + orderPrice();
        return resultat;
    }

    public void setTypePrice(double unPrix) {
        priceType = unPrix;
    }

    public void setOptionPrice(double unPrix) {
        priceOptions = unPrix;
    }
    /**
     * This method adds a coffee.
     */
    public void addDrink(){
        this.numberOfDrink += 1;
    }

    /**
     * This method removes a coffee.
     */
    public void removeDrink(){
        this.numberOfDrink -= 1;
        if(this.numberOfDrink <0){
            this.numberOfDrink =0;
            this.priceType =0;
            this.priceOptions =0;
            this.price =0;
        }
    }

    /**
     * This method returns the number of the coffee in the order.
     */
    public int getNumberOfDrink(){
        return this.numberOfDrink;
    }

    /**
     * This method returns the price of the order.
     */
    public double orderPrice(){
        this.price = ( priceOptions + priceType);
        double tampon = price;
        price = tampon + price;
        return this.price;
    }
}



















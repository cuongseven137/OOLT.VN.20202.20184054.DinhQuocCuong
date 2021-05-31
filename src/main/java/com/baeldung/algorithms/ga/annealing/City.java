package com.baeldung.algorithms.ga.annealing;


public class City {

    private double x;
    private double y;
    public double getX() {
        return x;
    }
     
    
    public void setX(double x) {
        this.x = x;
    }
     
     
    // getter của thuộc tính y
    public double getY() {
        return y;
    }
     
    // setter của thuộc tính y
    public void setY(double y) {
        this.y = y;
    }

    // public City() {
    //     this.x = (int) (Math.random() * 500);
    //     this.y = (int) (Math.random() * 500);
    // }

    public City(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToCity(City city) {
        int x = (int) Math.abs(getX() - city.getX());
        int y = (int) Math.abs(getY() - city.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}

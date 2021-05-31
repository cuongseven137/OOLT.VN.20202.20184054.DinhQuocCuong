package com.baeldung.algorithms.ga.PSO;

public class City {
	double x = 0;
    double y = 0;
    static int count = 0;
    String cityName;
    public City() {
    	count ++;
    	this.cityName = "City " + Integer.toString(count);
    }
    public City(int x, int y) {
    	this.x = x;
    	this.y = y;
    	count++;
    	
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceTo(City city) {
        return Math.sqrt(((getX() - city.getX()) * (getX() - city.getX())) + ((getY() - city.getY()) * (getY() - city.getY())));
}
    public String toString(){
    	return this.cityName ;
    }
}
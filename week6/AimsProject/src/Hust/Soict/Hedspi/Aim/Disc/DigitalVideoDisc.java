package Disc;

import Media.*;


public class DigitalVideoDisc extends Media {
    private String director;
    private int length;


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title, String director, int length) {
        super(title);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(String title, String category, String director, int length) {
        super(title, category);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(int id,String title, String category, String director, int length ,float cost) {
        super(id,title, category, cost);
        this.director = director;
        this.length = length;
    }   

    @Override
    public String showInfo() {
        return "DVD.ID: " + getId() + "- Title: " + getTitle() + ", Category: " + getCategory() + ", Director: " + getDirector() + ", Length: " + getLength() + ", Price: "+ getCost();
    }   
}

package Disc;

public class DigitalVideoDisc extends Disc implements playable {
    public DigitalVideoDisc(String director, int length) {
        super(director, length);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost, director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, director, length);
    }  
    
    @Override
    public String showInfo() {
        return "DVD.ID: " + getId() + "- Title: " + getTitle() + ", Category: " + getCategory() + ", Director: " + getDirector() + ", Length: " + getLength() + ", Price: "+ getCost();
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}

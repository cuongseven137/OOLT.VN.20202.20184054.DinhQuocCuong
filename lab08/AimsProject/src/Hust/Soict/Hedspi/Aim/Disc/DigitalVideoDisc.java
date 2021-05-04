package Disc;

public class DigitalVideoDisc extends Disc implements playable {

    public DigitalVideoDisc(){}

    public DigitalVideoDisc(String director, int length) {
        super.director = director;
        super.length = length;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        super.id = id;
        super.title = title;
        super.category = category;
        super.cost = cost;
        super.director = director;
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super.id = id;
        super.title = title;
        super.category = category;
        super.cost = cost;
        super.director = director;
        super.length = length;
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

    // @Override
    // public int compareTo(DigitalVideoDisc d) {
    //     return this.getLength() - d.getLength();
    // }
}

package Disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(float cost, String category, String title) {

    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public boolean search(String title) {
        int count = 0;
        String[] s1 = getTitle().split("\\s");
        String[] s2 = title.split("\\s");
        for (String s3 : s2) {
            for (String s4 : s1) {
                if (s4.equalsIgnoreCase(s3)) {
                    count++;
                }
            }
        }
        if (count == s2.length)
            return true;
        else
            return false;
    }

    public String showInfo() {
        return "DVD: Title: " + getTitle() + " Director: " + getDirector() + " Category: " + getCategory() + " Price: "
                + getCost();
    }

}

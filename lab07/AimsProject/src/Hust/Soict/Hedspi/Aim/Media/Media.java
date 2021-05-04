package Media;

public abstract class Media {
    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public int getId() {
        return id;
    }

    public abstract String showInfo();
}

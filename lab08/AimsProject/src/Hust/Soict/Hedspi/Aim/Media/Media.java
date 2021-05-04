package Media;

public abstract class Media implements Comparable<Media>{
    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(Media m) {
        return this.getTitle().compareTo(m.getTitle());
    }
}

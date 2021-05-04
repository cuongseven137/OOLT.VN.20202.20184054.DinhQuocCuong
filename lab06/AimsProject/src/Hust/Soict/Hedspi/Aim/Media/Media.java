package Media;

public abstract class Media {
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    protected Media(String title){
        this.title = title;
    }

    protected Media(String title,String category){
        this.title = title;
        this.category = category;
    }  

    protected Media(String title,String category,float cost){
        this(title);
        this.category = category;
        this.cost=cost;
    } 

    protected Media(int id,String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = id;
    }
    
    public boolean search(String title){
        int count=0;
        String[] s1 = getTitle().split("\\s");
        String[] s2 = title.split("\\s");
        for(String s3 : s2){
            for(String s4 : s1){
                if(s4.equalsIgnoreCase(s3)){
                    count++;
                }
            }
        }
        if(count==s2.length) return true;
        else return false;
    }

    public abstract String showInfo();
}

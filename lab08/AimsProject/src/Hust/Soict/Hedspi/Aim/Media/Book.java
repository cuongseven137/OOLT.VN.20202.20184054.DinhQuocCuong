package Media;

import java.util.*;

public class Book extends Media {
    private String content;
    private List<String> contentTokens;
    private TreeMap<String,Integer> wordFrequency;

    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println("Already exist");
        }
        else authors.add(authorName);
    }

    public List<String> getContentTokens() {
        return contentTokens;
    }

    public void setContentTokens(List<String> contentTokens) {
        this.contentTokens = contentTokens;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        } else System.out.println("Does not exist");
    }

    public Book(){}

    public Book(String title){
        super.title = title;
    }

    public Book(String title,String category){
        super.title = title;
        super.category = category;
    }

    
    public Book(String title, String category, float cost) {
        super.title = title;
        super.category = category;
        super.cost = cost;
    }

    public Book(int id,String title,String category,float cost){
        super.id = id;
        super.title = title;
        super.category = category;
        super.cost = cost;
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super.id = id;
        super.title = title;
        super.category = category;
        super.cost = cost;
        this.authors = authors;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void processContent() {
        String[] a = content.split("[\\s\\.]");
        contentTokens = Arrays.asList(a);
        Collections.sort(contentTokens);
        String key="";
        Integer value;
        wordFrequency = new TreeMap<String, Integer>();
        for(int i=0;i<a.length;i++){
            key = a[i];
            if(wordFrequency.containsKey(key)){
                value = wordFrequency.get(key);
                wordFrequency.remove(key);
                wordFrequency.put(key, value+1);
            } else{
                wordFrequency.put(key, 1);
            }
        }
    }

    @Override
    public String toString() {
        return "Book. ID: " + getId() +  "- Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Authors: " + getAuthors()
                + ", token_list:" + getContentTokens() + ", wordFrequency:" + wordFrequency ;
    }
    
    @Override
    public String showInfo() {
        return "Book. ID: " + getId() +  "- Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Authors: " + getAuthors();
    }
}

package Disc;
import java.util.ArrayList;

public class CompactDisc extends Disc implements playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public int getLength(ArrayList<Track> tracks){
        int sumlength = 0;
        for(int i = 0 ; i < tracks.size() ; i++){
            sumlength += tracks.get(i).getLength();
        }
        super.length = sumlength;
        return super.length;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("Already exist");
        }
        else tracks.add(track);
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
        } else System.out.println("Does not exist");
    }

    public CompactDisc(String director, int length, String artist) {
        super(director, length);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, String artist,ArrayList<Track> tracks) {
        super(id, title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play(){
        for(int i = 0; i<tracks.size() ; i++){
            System.out.println("Playing CD: " + tracks.get(i).getTitle());
            System.out.println("CD length: " + tracks.get(i).getLength());
        }
    }

    @Override
    public String showInfo() {
        return "CD.ID: " + getId() + "- Title: " + getTitle() + ", Category: " + getCategory() + ", Director: " + getDirector() + ", Length: " + getLength() + ", Price: "+ getCost() + ", Artist: " + getArtist();
    }
}

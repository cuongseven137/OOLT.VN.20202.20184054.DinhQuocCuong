package Disc;
import java.util.Scanner;
import Media.*;
import java.util.ArrayList;

public class CDFactory implements AbstractItemFactory  {
    @Override

    public Media createItemFromConsole(){
        CompactDisc cd = new CompactDisc();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: "); cd.setTitle(sc.nextLine());
        System.out.print("Enter category: "); cd.setCategory(sc.nextLine()); 
        System.out.print("Enter Cost: "); cd.setCost(sc.nextFloat());
        sc.nextLine();
        System.out.print("Enter director: "); cd.setDirector(sc.nextLine()); 
        System.out.print("Enter artist: "); cd.setArtist(sc.nextLine()); 
        System.out.print("Enter the number of trasks: "); int number = sc.nextInt(); 
        ArrayList<Track> tracks = new ArrayList<>();
        sc.nextLine();
        for(int i = 0; i < number ; i++){
            System.out.print("Enter title of trask: "); String titletrask = sc.nextLine();
            System.out.print("Enter length of trask: "); int lengthtrack = sc.nextInt();
            sc.nextLine();
            Track track = new Track(titletrask,lengthtrack);
            tracks.add(track);
        }
        cd.getLength(tracks);
        System.out.println("Do you want to play?\n1.Yes  2.No");
        System.out.print("You choose: ");
        int chon = sc.nextInt();
        sc.nextLine();
        boolean check = true;
        do{
            switch(chon){
                case 1:
                    cd.play();
                    check = false;
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.println("Enter incorrectly, re-enter");
                    break; 
            }
        }while(check);     

        return cd;
    }
}

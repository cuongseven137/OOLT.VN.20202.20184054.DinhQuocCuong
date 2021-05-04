import Media.*;
import Disc.*;
import java.util.*;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 11, 77.9f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3,"The Dark Knight", "Action Movie", "Christopher Nolan", 33, 99.4f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(5,"Die Hard", "Action Movie", "John McTiernan", 55, 222.3f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(7,"Conan", "Action Movie", "Christopher Nolan", 80, 40.7f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(9,"Harry Potter", "Action Movie", "Christopher Nolan", 76, 30.5f);
        java.util.Collection collection = new java.util.ArrayList();
        java.util.Collection collection1 = new java.util.ArrayList();
        collection.add(dvd2);
        collection.add(dvd1);
        collection.add(dvd3);
        collection.add(dvd4);
        collection.add(dvd5);

        java.util.Iterator iterator = collection.iterator();

        System.out.println("-------------------------------");
        System.out.println("The DVDs currently in the order are: ");
        while(iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List)collection);
        iterator = collection.iterator();

        System.out.println("-------------------------------");
        System.out.println("The DVDs in sorted order are: ");
        while(iterator.hasNext()){
            System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
        }
        System.out.println("-------------------------------");
    }
}

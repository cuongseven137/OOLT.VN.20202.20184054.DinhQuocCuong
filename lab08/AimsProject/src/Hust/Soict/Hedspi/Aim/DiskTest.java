import Order.Order;
import Disc.*;
import Media.*;

import java.util.*;

public class DiskTest {
    
    public static Order createOrder() {
        if (Order.checkNumberOfOrder()) {
            return new Order();
        } else {
            System.out.println("Cannot create more order...");
            return null;
        }
    }

    public static ArrayList<Media> listofitem(){
        ArrayList<Media> items = new ArrayList<>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 11, 77.9f);
        Book bk1 = new Book(2,"Star Wars", "Science Fiction", 88.7f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3,"The Dark Knight", "Action Movie", "Christopher Nolan", 33, 99.4f);
        Book bk2 = new Book(4,"Terminator 2: Judgment Day", "Action Movie", 111.9f,bk1.getAuthors());
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(5,"Die Hard", "Action Movie", "John McTiernan", 55, 222.3f);
        Book bk3 = new Book(6,"Inception", "Action Movie",33.2f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(7,"Conan", "Action Movie", "Christopher Nolan", 80, 40.7f);
        Book bk4 = new Book(8,"One Piece", "Action Movie",70.8f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(9,"Harry Potter", "Action Movie", "Christopher Nolan", 76, 30.5f);
        Book bk5 = new Book(10,"Dragon","Action Movie",323.9f); 
        bk1.addAuthor("nguyen");
        bk2.addAuthor("tuan");
        bk2.removeAuthor("nguyen");
        bk3.addAuthor("tuan");
        bk3.addAuthor("nguyen");
        bk4.addAuthor("tuan");
        bk4.addAuthor("nguyen");
        bk5.addAuthor("tuan");
        items.add(dvd1);
        items.add(bk1);
        items.add(dvd2);
        items.add(bk2);
        items.add(dvd3);
        items.add(bk3);
        items.add(dvd4);
        items.add(bk4);
        items.add(dvd5);
        items.add(bk5);
        return items;
    }

    public static void main(String[] args) {
       
    }
}

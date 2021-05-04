import Media.*;
import Disc.*;
import Order.*;
import Utils.Mydate;

import java.util.*;

public class Aims {

    public static Order createOrder() {
        if (Order.checkNumberOfOrder()) {
            System.out.println("Order has been created");
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

    public static Media createMediaItemFromConsole(AbstractItemFactory factory){
        return factory.createItemFromConsole();
    }

    public static void main(String[] args) {  
        ArrayList <Media> items = listofitem();
        Order order = new Order();
        Mydate date = new Mydate("mot", "hai", "2000");
        date.print();

        java.util.Iterator iterator = items.iterator();

        System.out.println("-------------------------------");
        System.out.println("The media currently in the order are: ");
        while(iterator.hasNext()){
            System.out.println(((Media)iterator.next()).getTitle());
        }

        java.util.Collections.sort((java.util.List)items);
        iterator = items.iterator();

        System.out.println("-------------------------------");
        System.out.println("The media in sorted order are: ");
        while(iterator.hasNext()){
            System.out.println(((Media)iterator.next()).getTitle());
        }
        System.out.println("-------------------------------");
        
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int select;
        do {
            System.out.println("Product Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create new item");
            System.out.println("2. Delete item by id");
            System.out.println("3. Display the items list");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            System.out.print("You choose: ");
            select=sc.nextInt();
            sc.nextLine();
            switch(select) {
                case 1:
                    int chon;
                    boolean checked = true;
                    do {
                        System.out.println("1.Book  2.CompactDisc  3.DigitalVideoDisc");
                        System.out.print("You choose: ");
                        chon = sc.nextInt();
                        sc.nextLine();
                        switch(chon){
                            case 1:
                                items.add(createMediaItemFromConsole(new BookFactory()));
                                checked = false;
                                break;
                            case 2:
                                items.add(createMediaItemFromConsole(new CDFactory()));
                                checked = false;
                                break;
                            case 3:
                                items.add(createMediaItemFromConsole(new DVDFactory()));
                                checked = false;
                                break;
                            default:
                                System.out.println("Enter incorrectly, re-enter");
                                break; 
                        }
                    }while(checked);
                    break;
                case 2:
                    System.out.print("Enter the Id you want to delete: "); int id = sc.nextInt();
                    order.removeItembyid(items,id);
                    break;
                case 3: 
                    order.show(items);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    check = false;
                    break;
                default:
                    System.out.println("Enter incorrectly, re-enter");
                    break;
            }
        } while(check);
    }
}

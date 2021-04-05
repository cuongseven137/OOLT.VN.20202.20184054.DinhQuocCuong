import Order.Order;
import Disc.*;
import Media.*;
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
    public static void main(String[] args) {  
        Order order = new Order();
        ArrayList <Media> items = new ArrayList<Media>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Lion King", "Animation", "Roger Allers", 11, 77.9f);
        Book bk1 = new Book(2,"Star Wars", "Science Fiction", 88.7f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(3,"The Dark Knight", "Action Movie", "Christopher Nolan", 33, 99.4f);
        Book bk2 = new Book(4,"Terminator 2: Judgment Day", "Action Movie", 111.9f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(5,"Die Hard", "Action Movie", "John McTiernan", 55, 222.3f);
        Book bk3 = new Book(6,"Inception", "Action Movie",33.2f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(7,"Conan", "Action Movie", "Christopher Nolan", 80, 40.7f);
        Book bk4 = new Book(8,"One Piece", "Action Movie",70.8f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(9,"Harry Potter", "Action Movie", "Christopher Nolan", 76, 30.5f);
        Book bk5 = new Book(10,"Dragon","Action Movie",323.9f); 
        bk1.addAuthor("tuan");
        bk2.addAuthor("tuan");
        bk3.addAuthor("tuan");
        bk3.addAuthor("nguyen");
        bk4.addAuthor("tuan");
        bk4.addAuthor("nguyen");
        bk5.addAuthor("tuan");
        items.add(bk3);
        items.add(dvd4);
        items.add(bk4);
        items.add(dvd5);
        items.add(bk5);

        Mydate date = new Mydate("mot", "hai", "2000");
        date.print();
        
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        boolean checkcase2 = false;
        int select;
        do {
            System.out.println("Order Management Application: ");
            System.out.println("--------------------------------");
            System.out.println("1. Create new order");
            System.out.println("2. Add item to the order");
            System.out.println("3. Delete item by id");
            System.out.println("4. Display the items list of order");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            System.out.print("You choose: ");
            select=sc.nextInt();
            sc.nextLine();
            switch(select) {
                case 1:
                    if(createOrder() == null){
                        break;
                    } else{
                        order.removeItem(itemsOrdered);
                        checkcase2 = false;
                    }
                    break;
                case 2:
                    order.addItem(dvd1);
                    order.addItem(bk1, dvd2);
                    order.addItem(bk2, dvd3);
                    order.addItem(items);
                    order.randomLuckyItem();
                    checkcase2 = true;
                    break;
                case 3:
                    if(checkcase2){
                        System.out.print("Enter the Id you want to delete: "); int id = sc.nextInt();
                        order.removeItembyid(id);
                    }else {System.out.println("Please choose 2 first");}
                    break;
                case 4:
                    if(checkcase2){  
                        order.show();
                    }else {System.out.println("Please choose 2 first");}
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

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

    public static Media createMediaItemFromConsole(AbstractItemFactory factory){
        return factory.createItemFromConsole();
    }

    public static void main(String[] args) {  
        ArrayList <Media> items = new ArrayList<>();
        Order order = new Order();
        Mydate date = new Mydate("mot", "hai", "2000");
        date.print();
        
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

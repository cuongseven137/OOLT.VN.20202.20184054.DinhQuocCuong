package Disc;
import java.util.Scanner;

import Media.*;

public class DVDFactory implements AbstractItemFactory{
    @Override

    public Media createItemFromConsole(){
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: "); dvd.setTitle(sc.nextLine());
        System.out.print("Enter category: "); dvd.setCategory(sc.nextLine()); 
        System.out.print("Enter Cost: "); dvd.setCost(sc.nextFloat());
        sc.nextLine();
        System.out.print("Enter director: "); dvd.setDirector(sc.nextLine()); 
        System.out.print("Enter length: "); dvd.setLength(sc.nextInt());
        System.out.println("Do you want to play?\n1.Yes  2.No");
        System.out.print("You choose: ");
        int chon = sc.nextInt();
        sc.nextLine();
        boolean check = true;
        do{
            switch(chon){
                case 1:
                    dvd.play();
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

        return dvd;
    }
}
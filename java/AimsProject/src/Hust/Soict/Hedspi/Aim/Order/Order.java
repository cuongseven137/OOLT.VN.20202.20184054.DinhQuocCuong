package Order;
import Disc.*;

import java.lang.Math;

public class Order {

    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERED = 5;
    public static Order or[] = new Order[MAX_LIMITED_ORDERED];
    public static int nbOrder = 0;
    int dem = 0;
    int rand = 10;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public Order(){
        nbOrder++;
    }

    public DigitalVideoDisc[] getDvdList() {
        return itemsOrdered;
    }


    public void qtyOrdered() {
        dem++;
        if (dem < MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Đã được thêm vào Order");
        }
        if (dem == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Đã được thêm vào Order,Order sắp đầy");
        }
        if (dem == MAX_NUMBERS_ORDERED ) {
            System.out.println("Đã được thêm vào Order,Order đã đầy");
        }
        if (dem > MAX_NUMBERS_ORDERED ) {
            System.out.println("Đã đầy, không thể thêm");
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(nbOrder<=MAX_LIMITED_ORDERED){
            if (dem < MAX_NUMBERS_ORDERED) {
                itemsOrdered[dem] = disc;
                qtyOrdered();
            }else {
                qtyOrdered();
                dem--;
            }
        } else{ System.out.println("quá giới hạn,k được thêm vào order");}
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        if(nbOrder<=MAX_LIMITED_ORDERED){
            if (dem < MAX_NUMBERS_ORDERED) {
                itemsOrdered[dem] = disc1;
                qtyOrdered();
            }else {
                qtyOrdered();
                dem--;
            }
            if (dem < MAX_NUMBERS_ORDERED) {
                itemsOrdered[dem] = disc2;
                qtyOrdered();
            } else {
                qtyOrdered();
                dem--;
            }
        } else{ System.out.println("quá giới hạn,k được thêm vào order");}
    }
    
    // Thêm mảng dvd vào order
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if(nbOrder<=MAX_LIMITED_ORDERED){
            for (int i = 0; i < dvdList.length; i++) {
                if(dem < MAX_NUMBERS_ORDERED){
                    itemsOrdered[dem] = dvdList[i];
                    qtyOrdered();
                }else {
                    qtyOrdered();
                    dem--;
                }
            } 
        } else{ System.out.println("quá giới hạn,k được thêm vào order");}
    }
        
    public void show(){
        for(int i = 0; i < dem; i++) {
            System.out.println("Id: " + (i + 1));
            System.out.println("Title: " + itemsOrdered[i].getTitle());
            System.out.println("Category: " + itemsOrdered[i].getCategory());
            System.out.println("Director: " + itemsOrdered[i].getDirector());
            System.out.println("Length: " + itemsOrdered[i].getLength());
            System.out.println("Cost: " + itemsOrdered[i].getCost());
            System.out.println("------------------------------------");
        }
    }
    
    public float totalCost() {
        float tong = 0;
        for (int i = 0; i < dem; i++) {
            tong += itemsOrdered[i].getCost();
        }
        if(rand != 10){
            tong -= getALuckyItem().getCost();
        }
        return tong;
    }

  

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i=0;i<dem;i++){
            if (itemsOrdered[i] == disc){
                for (int j = i; j < dem-1; j++) {
                    itemsOrdered[j]=itemsOrdered[j + 1];
                }
                dem--;
                System.out.println("Đã xóa phần tử khỏi danh sách");
            }
        }
    }
        
   public DigitalVideoDisc getALuckyItem(){
        return itemsOrdered[rand];
    }

    public int random(){
        int range = 10;
        rand = (int)(Math.random() * range) ;
        return rand;
    }
}

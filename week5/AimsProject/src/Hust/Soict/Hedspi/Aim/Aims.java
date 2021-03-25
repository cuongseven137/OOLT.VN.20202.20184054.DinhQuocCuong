import Order.Order;
import Disc.*;
import Utils.Mydate;

import java.util.*;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 11, 77.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 22, 88.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action Movie", "Christopher Nolan", 33, 99.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Terminator 2: Judgment Day", "Action Movie", "James Cameron", 44, 111.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Die Hard", "Action Movie", "John McTiernan", 55, 222.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher Nolan", 66, 33.95f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher Nolan", 66, 333.5f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher Nolan", 66, 333.95f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher Nolan", 6, 333.95f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher", 66, 333.95f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Inception", "Action", "Christopher Nolan", 66, 333.95f);

        DigitalVideoDisc[] discs1 = {dvd7, dvd8, dvd9};
        DigitalVideoDisc[] discs2 = {dvd10, dvd11};
        Order order = new Order();
        order.addDigitalVideoDisc(dvd1);
        order.addDigitalVideoDisc(dvd2, dvd3);
        order.addDigitalVideoDisc(dvd4, dvd5);
        order.addDigitalVideoDisc(dvd6);
        order.addDigitalVideoDisc(discs1);
        order.addDigitalVideoDisc(discs2); 

        
        Mydate date = new Mydate("mot", "hai", "2000");
        date.print();
        
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int select;
        do {
            System.out.println("1. Hiện thị danh sách đơn hàng."); 
            System.out.println("2. Xóa sản phẩm trong đơn hàng."); 
            System.out.println("3. Tính tổng tiền."); 
            System.out.println("4. Thoát."); 
            System.out.print("Mời bạn chọn: "); 
            select=sc.nextInt();
            switch(select) {
                case 1:
                    order.show();
                    break;
                case 2:
                    order.show();
                    System.out.println("Mời bạn số id của sản phẩm để xóa."); 
                    int dvdId = sc.nextInt();
                    if (dvdId > 0 && dvdId <= 10) {
                        DigitalVideoDisc itemsOrdered[] = order.getDvdList();
                        order.removeDigitalVideoDisc(itemsOrdered[dvdId - 1]);
                    } else {
                        System.out.println("Id phải lớn hơn 0 và nhỏ hơn 10");
                    }
                    break;
                case 3:
                    System.out.println("Tổng tiền: " + order.totalCost()); 
                    break;
                case 4:
                    System.out.println("Xin chào tạm biệt!");
                    check = false;
                    break;
                default:
                    System.out.println("Nhập sai, hãy nhập lại");
                    break;
            }
        } while(check);
    }

}

import Disc.*;
import Order.Order;
import Utils.Mydate;
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

    public static void main(String[] args) {
        Order order = createOrder();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 11, 77.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 22, 88.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action Movie", "Christopher Nolan", 33,
                99.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Terminator 2: Judgment Day", "Action Movie", "James Cameron", 44,
                111.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Die Hard", "Action Movie", "John McTiernan", 55, 222.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Inception", "Action Movie", "Christopher Nolan", 66, 33.95f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Conan", "Action Movie", "Christopher Nolan", 80, 40.95f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("One Piece", "Action Movie", "Christopher Nolan", 100, 70.65f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Harry Potter", "Action Movie", "Christopher Nolan", 76, 30.95f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Dragon", "Action Movie", "Christopher Nolan", 132, 323.95f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Dragon", "Action Movie", "Christopher Nolan", 132, 323.95f);

        DigitalVideoDisc[] disc = { dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11 };
        order.addDigitalVideoDisc(dvd1);
        order.addDigitalVideoDisc(dvd2, dvd3);
        order.addDigitalVideoDisc(disc);

        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int select;
        do {
            System.out.println("1. Hiện thị danh sách đơn hàng.");
            System.out.println("2. Tìm kiếm title.");
            System.out.println("3. dvd lucky.");
            System.out.println("4. Tính tổng tiền.");
            System.out.println("5. Thoát.");
            System.out.print("Bạn chọn: ");
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
            case 1:
                order.show();
                break;
            case 2:
                DigitalVideoDisc itemsOrdered[] = order.getDvdList();
                int count = 0;
                System.out.print("Nhập tiêu đề muốn tìm: ");
                String td = sc.nextLine();
                System.out.println("Những dvd chứa tiêu đề " + td + " : ");
                for (int i = 0; i < itemsOrdered.length; i++) {
                    if (itemsOrdered[i].search(td) == true) {
                        System.out.println(itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - "
                                + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + " - "
                                + itemsOrdered[i].getCost());
                        count++;
                    }
                }
                if (count == 0)
                    System.out.println("Không có dvd nào chứa tiêu đề " + td);
                break;
            case 3:
                System.out.println("dvd may mắn được free");
                order.randomLuckyItem();
                System.out.println(order.itemsOrdered[order.getLuckyItem()].showInfo());
                break;
            case 4:
                System.out.println("Tổng tiền: " + order.totalCost());
                break;
            case 5:
                System.out.println("Xin chào tạm biệt!");
                check = false;
                break;
            default:
                System.out.println("Nhập sai, hãy nhập lại");
                break;
            }
        } while (check);
    }
}

package Order;

import Disc.*;

import java.lang.Math;

public class Order {

    public static final int MAX_NUMBERS_ORDERED_ITEMS = 10;
    public static final int MAX_LIMITED_ORDERED = 5;
    // public static Order or[] = new Order[MAX_LIMITED_ORDERED];
    public static int nbOrder = 0;
    // int dem = 0;
    private int luckyItem = 0;
    public DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED_ITEMS];

    public int getLuckyItem() {
        return luckyItem;
    }

    public static boolean checkNumberOfOrder() {
        return (nbOrder <= 5);
    }

    public Order() {
        nbOrder++;
    }

    public DigitalVideoDisc[] getDvdList() {
        return itemsOrdered;
    }

    public int getQuantityOrdered() {
        int count = 0;
        for (int i = 0; i < itemsOrdered.length; i++) {
            if (itemsOrdered[i] != null)
                count++;
        }
        return count;
    }

    public void verifyOrderedItem() {
        int dem = getQuantityOrdered();
        if (dem < MAX_NUMBERS_ORDERED_ITEMS - 1) {
            System.out.println("Đã được thêm vào Order");
        }
        if (dem == MAX_NUMBERS_ORDERED_ITEMS - 1) {
            System.out.println("Đã được thêm vào Order,Order đã đầy");
        }
        if (dem > MAX_NUMBERS_ORDERED_ITEMS - 1) {
            System.out.println("Đã đầy, không thể thêm");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        verifyOrderedItem();
        if (getQuantityOrdered() < MAX_NUMBERS_ORDERED_ITEMS)
            itemsOrdered[getQuantityOrdered()] = disc;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        addDigitalVideoDisc(disc1);
        addDigitalVideoDisc(disc2);
    }

    // Thêm mảng dvd vào order
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void show() {
        System.out.println("------------------------------------");
        for (int i = 0; i < getQuantityOrdered(); i++) {
            System.out.println(i + itemsOrdered[i].showInfo());
        }
        System.out.println("------------------------------------");
        System.out.println("Total cost: " + totalCost());
        System.out.println("Lucky Item gets free: " + itemsOrdered[luckyItem].showInfo());
    }

    public float totalCost() {
        float tong = 0;
        for (int i = 0; i < getQuantityOrdered(); i++) {
            tong += itemsOrdered[i].getCost();
        }
        randomLuckyItem();
        tong -= itemsOrdered[luckyItem].getCost();
        return tong;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < getQuantityOrdered(); i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < getQuantityOrdered() - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                System.out.println("Đã xóa phần tử khỏi danh sách");
                break;
            }
        }
    }

    public void randomLuckyItem() {
        int range = 10;
        this.luckyItem = (int) (Math.random() * range);
    }
}

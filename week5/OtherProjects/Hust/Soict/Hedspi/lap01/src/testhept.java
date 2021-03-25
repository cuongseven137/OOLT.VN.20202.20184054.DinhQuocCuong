package week1;
import java.util.*;
public class testhept {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a11: ");  int a11 = sc.nextInt();
        System.out.print("Nhập a12: ");  int a12 = sc.nextInt();
        System.out.print("Nhập b1: ");  int b1 = sc.nextInt();
        System.out.print("Nhập a21: ");  int a21 = sc.nextInt();
        System.out.print("Nhập a22: ");  int a22 = sc.nextInt();
        System.out.print("Nhập b2: ");  int b2 = sc.nextInt();
        hept hpt = new hept(a11,a12,a21,a22,b1,b2);
        System.out.println(hpt.resolve());
    }
}

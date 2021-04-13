package week1;
import java.util.*;
public class testptbacmot {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: ");  int a = sc.nextInt();
        System.out.print("Nhập b: ");  int b = sc.nextInt();
        ptbacmot pt = new ptbacmot(a,b);
        System.out.println("pt có dạng:"+a+"x + "+b+"=0");
        System.out.println(pt.resolve());
    }
}

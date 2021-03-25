package week1;
import java.util.*;
public class testptbachai {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a: "); int a = sc.nextInt();
        System.out.print("Nhập b: "); int b = sc.nextInt();
        System.out.print("Nhập c: "); int c = sc.nextInt();
        ptbachai pt2=new ptbachai(a, b, c);
        ptbacmot pt = new ptbacmot(b,c);
        if(a==0){
            System.out.println(pt.resolve());
        }else{System.out.println(pt2.resolve());}
    }
}

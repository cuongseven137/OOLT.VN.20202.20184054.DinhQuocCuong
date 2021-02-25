import java.util.Scanner;

public class pt1 {
    public static void main(String[] args) {
        double a, b;
        System.out.println("nhap cac he so cua phuong trinh: ");
        System.out.print("a =  ");
        a = new Scanner(System.in).nextDouble();
        System.out.print("b = ");
        b = new Scanner(System.in).nextDouble();
        ptbac1 eq = new ptbac1(a, b);
        System.out.println(eq.resolve(a, b));
    }
}
import java.util.Scanner;

public class pt {
    public static void main(String[] args) {
        double a, b, c;
        System.out.println("nhap he so cua phuong trinh: ");
        System.out.print("a = ");
        a = new Scanner(System.in).nextDouble();
        System.out.print("b = ");
        b = new Scanner(System.in).nextDouble();
        System.out.print("c = ");
        c = new Scanner(System.in).nextDouble();
        ptbac2 eq = new ptbac2(a, b, c);
        System.out.println(eq.resolve());
    }
}
import java.util.Scanner;

class phuongtrinh {
    public float a, b, c;
    double x1, x2;
    double delta;
    Scanner input = new Scanner(System.in);

    public void nhap() {
        System.out.print("nhap a: ");
        this.a = input.nextFloat();
        System.out.print("nhap b: ");
        this.b = input.nextFloat();
        System.out.print("nhap c: ");
        this.c = input.nextFloat();
    }

    public double tinhdelta() {
        delta = ((Math.pow(b, 2)) - 4 * a * c);
        return delta;
    }

    public double nghiemduynhat() {
        x1 = -c / b;
        return x1;
    }

    public double nghiemkep() {
        x1 = -b / (2 * a);
        return x1;
    }

    public void nghiemphanbiet() {
        x1 = ((-b + Math.sqrt(delta)) / (2 * a));
        x2 = ((-b - Math.sqrt(delta)) / (2 * a));
        System.out.println("x1= " + x1);
        System.out.println("x2= " + x2);
    }
}

import static java.lang.Math.sqrt;

public class ptbac2 {
    private double a;
    private double b;
    private double c;
    private double dt;

    public ptbac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double A() {
        return a;
    }

    public void A(double a) {
        this.a = a;
    }

    public double B() {
        return b;
    }

    public void B(double b) {
        this.b = b;
    }

    public double C() {
        return c;
    }

    public void C(double c) {
        this.c = c;
    }

    public String resolve() {
        dt = b * b - 4 * a * c;
        if (dt == 0)
            return "phuong trinh co nghiem duy nhat: " + -b / 2 * a + ".";
        else if (dt < 0)
            return "phuong trinh vo nghiem.";
        else
            return " phuong trinh co cap nghiem: " + (-b + sqrt(dt)) / (2 * a) + " va " + (-b - sqrt(dt)) / (2 * a)
                    + ".";
    }
}
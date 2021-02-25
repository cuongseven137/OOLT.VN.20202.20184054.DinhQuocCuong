public class ptbac1 {
    private double a;
    private double b;

    public ptbac1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double A() {
        return this.a;
    }

    public void A(double a) {
        this.a = a;
    }

    public double B() {
        return this.b;
    }

    public void B(double b) {
        this.b = b;
    }

    public String resolve(double a, double b) {
        if (a == 0 && b == 0)
            return ("phuong trinh vo so nghiem.");
        else if (a != 0)
            return ("phuong trinh co nghiem la: " + -b / a + ".");
        else
            return ("phuong trinh vo nghiem.");
    }
}
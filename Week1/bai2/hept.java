public class hept {
    private double a11;
    private double a12;
    private double b1;
    private double a21;
    private double a22;
    private double b2;
    private double d;
    private double d1;
    private double d2;

    public hept(double a11, double a12, double b1, double a21, double a22, double b2) {
        this.a11 = a11;
        this.a12 = a12;
        this.b1 = b1;
        this.a21 = a21;
        this.a22 = a22;
        this.b2 = b2;
    }

    public double A11() {
        return a11;
    }

    public void A11(double a11) {
        this.a11 = a11;
    }

    public double A12() {
        return a12;
    }

    public void A12(double a12) {
        this.a12 = a12;
    }

    public double B1() {
        return b1;
    }

    public void B(double b1) {
        this.b1 = b1;
    }

    public double A21() {
        return a21;
    }

    public void A21(double a21) {
        this.a21 = a21;
    }

    public double A22() {
        return a22;
    }

    public void A22(double a22) {
        this.a22 = a22;
    }

    public double B2() {
        return b2;
    }

    public void B2(double b2) {
        this.b2 = b2;
    }

    public String resolve() {
        d = A11() * A22() - A21() * A12();
        d1 = B1() * A22() - B2() * A12();
        d2 = A11() * B2() - A21() * B1();
        if (d == 0)
            if (d1 == 0 && d2 == 0)
                return "he phuong trinh vo so nghiem.";
            else
                return "he phuong trinh vo nghiem.";
        else
            return "he phuong trinh co nghiem (x1/x2) la : ( " + d1 / d + " ," + d2 / d + " )";
    }
}
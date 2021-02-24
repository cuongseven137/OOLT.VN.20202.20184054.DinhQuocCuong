class dieukien {
    phuongtrinh pt = new phuongtrinh();

    public void nhappt() {
        pt.nhap();
    }

    public void kiemtra() {
        if (pt.a == 0) {
            if (pt.b == 0) {
                System.out.print("phuong trinh vo so nghiem");
            } else {

                System.out.print("phuong trinh co nghiem duy nhat: " + pt.nghiemduynhat());
            }
        } else {
            if (pt.tinhdelta() < 0) {
                System.out.print("phuong trinh vo nghiem");
            }

            else {
                if (pt.tinhdelta() == 0) {
                    System.out.print("phuong trinhg co nghiem kep: " + pt.nghiemkep());
                } else {
                    System.out.println("phuong trinh co 2 nghiem phan biet: ");
                    pt.nghiemphanbiet();
                }
            }
        }
    }
}

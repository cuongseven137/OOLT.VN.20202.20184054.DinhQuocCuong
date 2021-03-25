import java.util.*;

public class testbai2 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        bai2 b2=new bai2();
        boolean cont = true;
        System.out.println("1:nhập tháng bằng chữ");
        System.out.println("2:nhập tháng bằng số");
        do{
            System.out.print("bạn chon số: "); int chon=sc.nextInt();
            switch (chon) {
                case 1:   
                    b2.nhap();
                    b2.nhapnam();
                    b2.inngay();
                    cont = false;
                    break;
                case 2:
                    b2.nhapthang();
                    b2.nhapnam();
                    b2.inngay();
                    cont = false;
                    break;
                default:
                    System.out.println("chon sai,chọn lại");
                    break;
            }
        }while(cont);   
    }
}

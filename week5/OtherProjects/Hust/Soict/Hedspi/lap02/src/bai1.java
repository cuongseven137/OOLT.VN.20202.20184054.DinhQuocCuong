import java.util.*;

public class bai1 {
    private int a;
    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.print("nhap a: "); a=sc.nextInt();
    }

    public void xuat(){
        for(int i=1;i<=a;i++){
            int k=a-i;
            while(k>0){
                System.out.print(" ");
                k--;
            }
            for(int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

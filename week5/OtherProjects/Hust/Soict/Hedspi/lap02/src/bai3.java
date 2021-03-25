
import java.util.*;

public class bai3 {
    private int x,a[],sum=0;
    Scanner sc = new Scanner(System.in);

    public void nhap(){
        System.out.print("ban muon nhap bao nhieu so: "); x=sc.nextInt();
    }

    public void nhapmang(){
        a= new int[x];
        for(int i=0;i<x;i++){
            System.out.print("x"+(i+1)+"="); a[i]=sc.nextInt();
        }
    }

    public void sapxep(){
        for(int i=0;i<x;i++){
            int min=a[i];
            for(int j=i+1;j<x;j++){
                if(a[j]<min){
                    min=a[j];
                    a[j]=a[i];
                    a[i]=min;
                }
            }
        }
    }

    public void xuatmang(){
        for(int i=0;i<x;i++){
            System.out.println("x"+(i+1)+"="+a[i]);
        }
    }

    public void tong(){
        for(int i=0;i<x;i++){
            sum += a[i];
        }
        System.out.println("tổng="+sum);
    }

    public void tb(){
        double tb=(double)sum/x;
        System.out.println("giá trị trung bình="+tb);
    }
}


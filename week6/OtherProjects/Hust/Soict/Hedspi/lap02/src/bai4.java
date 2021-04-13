
import java.util.*;

public class bai4 {
    private int x,y,a[][],b[][];

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap x="); x=sc.nextInt();
        System.out.print("nhap y="); y=sc.nextInt();
    }

    public void nhapmt1(){
        Scanner sc = new Scanner(System.in);
        a=new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print("nhập a["+i+"]["+j+"]="); a[i][j]=sc.nextInt();
            }
        }
    }

    public void nhapmt2(){
        Scanner sc = new Scanner(System.in);
        b=new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print("nhập b["+i+"]["+j+"]="); b[i][j]=sc.nextInt();
            }
        }
    }

    public void xuatmt1(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print(a[i][j]); 
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void xuatmt2(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                System.out.print(b[i][j]); 
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}

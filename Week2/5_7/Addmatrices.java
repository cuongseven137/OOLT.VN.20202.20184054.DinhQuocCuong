
import java.util.Scanner;



public class Addmatrices{
    public static void main(String[] args) {
        int m, n; // số dòng và số cột của ma trận 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số dòng của ma trận : ");
        m = scanner.nextInt();
        System.out.println("Nhập vào số cột của ma trận : ");
        n = scanner.nextInt();
        int[][] A = new int[m][n];
        int[][] B = new int[m][n];
        int[][] C = new int[m][n];//tổng của 2 ma trận
        System.out.println("Nhập Ma trận A: ");
        input(A, m, n);
        System.out.println("Nhập Ma trận B: ");
        input(B, m, n);
        add(A,B,C,m,n);
        System.out.println("Ma trận A: ");
        output(A, m, n);
        System.out.println("Ma trận A: ");
        output(B, m, n);
        System.out.println("Tổng của hai ma trận: ");
        output(C, m, n);

    }
    public static void input(int [][] arr,int m,int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr[" + i + "]["+ j + "] = ");
                arr[i][j] = scanner.nextInt();
            }
        }
    }

    public static void output(int [][] arr,int m,int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void add(int [][] A,int[][] B ,int[][] C,int m,int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j]=A[i][j]+B[i][j];
            }
        }
    }


}

        

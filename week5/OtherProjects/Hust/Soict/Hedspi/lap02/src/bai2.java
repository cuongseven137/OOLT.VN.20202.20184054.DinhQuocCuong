import java.util.*;

public class bai2 {
    private int y,m;
    private String s;
    Scanner sc = new Scanner(System.in);

    public void nhap(){
        String s11="January",s12="Jan.",s13="Jan",s21="February",s22="Feb.",s23="Feb",s31="March",s32="Mar.",s33="Mar",
        s41="April",s42="Apr.",s43="Apr",s5="May",s61="June",s62="Jun",s71="July",s72="Jul",s81="August",s82="Aug.",s83="Aug",
        s91="September",s92="Sept.",s93="Sept",s101="October",s102="Oct.",s103="Oct",s111="November",s112="Nov.",s113="Nov",
        s121="December",s122="Dec.",s123="Dec";
        while(m<=0 || m>=13){
            System.out.print("nhập tháng: "); s=sc.nextLine();
            if(s.equals(s11)==true || s.equals(s12)==true || s.equals(s13)==true) m=1;
            if(s.equals(s21)==true || s.equals(s22)==true || s.equals(s23)==true) m=2;
            if(s.equals(s31)==true || s.equals(s32)==true || s.equals(s33)==true) m=3;
            if(s.equals(s41)==true || s.equals(s42)==true || s.equals(s43)==true) m=4;
            if(s.equals(s5)==true) m=5;
            if(s.equals(s61)==true || s.equals(s62)==true) m=6;
            if(s.equals(s71)==true || s.equals(s72)==true) m=7;
            if(s.equals(s81)==true || s.equals(s82)==true || s.equals(s83)==true) m=8;
            if(s.equals(s91)==true || s.equals(s92)==true || s.equals(s93)==true) m=9;
            if(s.equals(s101)==true || s.equals(s102)==true || s.equals(s103)==true) m=10;
            if(s.equals(s111)==true || s.equals(s112)==true || s.equals(s113)==true) m=11;
            if(s.equals(s121)==true || s.equals(s122)==true || s.equals(s123)==true) m=12;
            if(m<=0 || m>=13){System.out.println("bạn đã nhập sai, hãy nhập lại ");}
        }
    }

    public void nhapthang(){
        while (m<=0 || m>=13) {
            System.out.print("nhập tháng: "); m= sc.nextInt();
            if(m<=0 || m>=13){System.out.println("bạn đã nhập sai, hãy nhập lại ");}
        } 
    }

    public void nhapnam(){
        while (y<=1000) {
            System.out.print("nhập năm: "); y= sc.nextInt();
            if(y<=1000){ System.out.println("bạn đã nhập sai, hãy nhập lại ");}
        }
    }

    public void inngay(){
        if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
            System.out.println("có 31 ngày");
        }
        if(m==4 || m==6 || m==9 || m==11){
            System.out.println("có 30 ngày");
        }
        if(m==2){
            if(y%100==0 && y%400==0){System.out.println("có 29 ngày");}
            else if(y%100!=0 && y%4==0){System.out.println("có 29 ngày");}
            else {System.out.println("có 28 ngày");}
        }
    }
}
        

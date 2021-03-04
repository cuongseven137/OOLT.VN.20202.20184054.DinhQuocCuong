import java.time.Month;
import java.time.Year;
import java.util.Scanner;

public class Test_DayInMonth {
    public static void main(String[] args){
     String Month_s=null;
     int Month=0,Year;
    DayInMonth Days;
    Scanner scanner = new Scanner(System.in);
        do{
            System.out.printf("Nhập Tháng: ");
            System.out.printf("Month= ");
            Month_s = new Scanner(System.in).nextLine();
            switch (Month_s) {
                case"1": case "January": case "Jan": case "Jan.": case "jan": case "jan.": 
                    Month = 1;
                    break;

                case"2": case "February": case "Feb": case "Feb.": case "feb": case "feb.":
                    Month=2;
                    break;

                case"3": case "March": case "Mar": case "Mar.": case "mar": case "mar.":
                    Month = 3;
                    break;

                case"4": case "April": case "Apr": case "Apr.": case "apr": case "apr.":
                    Month = 4;
                    break;

                case"5": case "May": case "May.": case "may": case "may.":
                    Month = 5;
                    break;

                case"6":  case "June": case "Jun":  case "Jun.":  case "jun":  case "jun.":
                    Month = 6;
                    break;

                case"7": case "July": case "Jul": case "Jul.": case "jul": case "jul.":
                    Month = 7;
                    break;

                case"8": case "August": case "Aug": case "Aug.": case "aug": case "aug.":
                    Month = 8;
                    break;

                case"9": case "September": case "Sep": case "Sept.": case "sep": case "sep.":
                    Month = 9;
                    break;

                case"10": case "October": case "Oct": case "Oct.":  case "oct":  case "oct.":
                    Month = 10;
                    break;

                case"11": case "November": case "Nov": case "Nov.": case "nov": case "nov.":
                    Month = 11;
                    break;

                case"12": case "December": case "Dec": case "Dec.": case "dec": case "dec.":
                    Month = 12;
                    break;

                default:
                    System.out.println("Nhập sai tháng mời nhập lại");
            }
            System.out.println("Nhập Năm: ");
            System.out.print("Year =  ");
            Year=scanner.nextInt();
            Days = new DayInMonth(Month, Year);

        }while (Days.verifyDate(Month,Year) != true );
        System.out.print("Số ngày của tháng là: ");
        System.out.println(Days.DaysInMonth(Month,Year));
    }

}


package Utils;

import java.util.*;

public class Mydate {
    private String day;
    private String month;
    private String year;
    Scanner sc = new Scanner(System.in);
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public Mydate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int ngay(String day){
        switch(day){
            case "mot":
                return 1;
            case "hai":
                return 2;
            case "ba":
                return 3;
            case "bon":
                return 4;
            case "nam":
                return 5;
            case "sau":
                return 6;
            case "bay":
                return 7;
            case "tam":
                return 8;
            case "chin":
                return 9;
            case "muoi":
                return 10;
            case "muoi mot":
                return 11;
            case "muoi hai":
                return 12;
            case "muoi ba":
                return 13;
            case "muoi bon":
                return 14;
            case "muoi nam":
                return 15;
            case "muoi sau":
                return 16;
            case "muoi bay":
                return 17;
            case "muoi tam":
                return 18;
            case "muoi chin":
                return 19;
            case "hai muoi":
                return 20;
            case "hai mot":
                return 21;
            case "hai hai":
                return 22;
            case "hai ba":
                return 23;
            case "hai bon":
                return 24;
            case "hai nam":
                return 25;
            case "hai sau":
                return 26;
            case "hai bay":
                return 27;
            case "hai tam":
                return 28;
            case "hai chin":
                return 29;
            case "ba muoi":
                return 30;
            case "ba mot":
                return 31;
            default:
                return 0;
        }
    }

    public int thang(String month){
        switch(month){
            case "mot":
                return 1;
            case "hai":
                return 2;
            case "ba":
                return 3;
            case "bon":
                return 4;
            case "nam":
                return 5;
            case "sau":
                return 6;
            case "bay":
                return 7;
            case "tam":
                return 8;
            case "chin":
                return 9;
            case "muoi":
                return 10;
            case "muoi mot":
                return 11;
            case "muoi hai":
                return 12;
            default:
                return 0;
        }
    }

    public void print(){
        System.out.println(ngay(day) + "-" + thang(month) + "-" + year);
    }
}

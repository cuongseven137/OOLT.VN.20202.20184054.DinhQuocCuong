

public class DayInMonth {
    private int Month;
    private int Year;
    public DayInMonth(int Month, int Year){
        this.Month= Month;
        this.Year = Year;
      }
    
    public double getMonth() {
        return this.Month;
    }

    public void setMonth(int Month) {
        this.Month= Month;
    }

    public double getYear() {
        return this.Year;
    }

    public void setYearYear(int Year) {
        this.Year= Year;
    }

    public int DaysInMonth(int Month, int Year){
        if (Month==1 || Month==3 || Month==5 || Month==7 || Month==8 || Month==10 || Month==12 ) return 31;
        else if (Month==4 || Month==6 || Month==9 || Month==11 ) return 30;
        else if(Month==2 && Year % 4 == 0) return 29;
        else return 28;
    }

    public boolean verifyDate(int Month,int Year){
        return(Month>=1 && Month <=12)&&(Year>=1900 && Year <=9999);
    }

}

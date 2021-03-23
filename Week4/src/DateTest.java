
public class DateTest {
    public static void main(String[] args) {
        MyDate Date1 = new MyDate("third","June","twenty sixteen");
        MyDate Date2 = new MyDate("twenty-sixth","December","twenty seventeen");
        MyDate[] dateList = {Date2,Date1}; 
        Date1.print();
        Date2.print();
        System.out.printf("Date1 vs Date2 is: %d\n", DateUtils.compareMyDate(Date1, Date2));
        System.out.print("Before: ");
        DateUtils.print(dateList);
        DateUtils.sortMyDate(dateList);
        System.out.print("After: ");
        DateUtils.print(dateList);
    }
}
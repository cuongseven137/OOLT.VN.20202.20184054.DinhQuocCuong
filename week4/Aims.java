package week4;

public class Aims {
    public static void main (String[] args){
        Order anOrder = new Order() ;
        Mydate date = new Mydate("muoi","chin","2000");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        DigitalVideoDisc[] disc={dvd1,dvd2,dvd3,dvd4,dvd5};
        System.out.print("***********************Order 1***********************\nDate: ");
        date.print();
        System.out.println("Ordered Items: ");
        anOrder.addDigitalVideoDiscmang(disc);
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost(disc));
        System.out.println("***************************************************");  
        
        
        Order anOrder1 = new Order() ;
        Mydate date1 = new Mydate("tam","chin","2000");
        DigitalVideoDisc[] disc1={dvd1,dvd2,dvd5};
        System.out.print("***********************Order 2***********************\nDate: ");
        date1.print();
        System.out.println("Ordered Items: ");
        anOrder1.addDigitalVideoDiscmang(disc1);
        System.out.print("Total Cost is: ");
        System.out.println(anOrder1.totalCost(disc1));
        System.out.println("***************************************************");   
        
        Order anOrder2 = new Order() ;
        Mydate date2 = new Mydate("bay","chin","2000");
        DigitalVideoDisc[] disc2={dvd1,dvd2,dvd5};
        System.out.print("***********************Order 3***********************\nDate: ");
        date2.print();
        System.out.println("Ordered Items: ");
        anOrder2.addDigitalVideoDiscmang(disc2);
        System.out.print("Total Cost is: ");
        System.out.println(anOrder2.totalCost(disc2));
        System.out.println("***************************************************"); 
    }
}

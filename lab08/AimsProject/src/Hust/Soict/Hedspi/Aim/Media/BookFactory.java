package Media;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BookFactory implements AbstractItemFactory {
    @Override

    public Media createItemFromConsole(){
        Book book = new Book();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: "); book.setTitle(sc.nextLine());
        System.out.print("Enter category: "); book.setCategory(sc.nextLine()); 
        System.out.print("Enter Cost: "); book.setCost(sc.nextFloat());
        sc.nextLine();
        List<String> authors = new ArrayList<String>();
        System.out.print("Enter author: \t"); 
        int i=0;
        while(true){
            System.out.print("author" + i + 1 + ":");
            authors.add(sc.nextLine());
            System.out.println("Continue?");
            if(sc.nextLine().compareTo("y") == 0 ) break;
        }
        book.setAuthors(authors);    

        return book;
    }
}

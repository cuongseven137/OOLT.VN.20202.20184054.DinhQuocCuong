import Media.*;
import java.util.*;

public class BookTest {
    public static void main(String[] args) {
        ArrayList<String> list_author = new ArrayList<>();
        list_author.add("tuan");
        list_author.add("nguyen");

        Book bk1 = new Book(2,"Star Wars", "Science Fiction", 88.7f, list_author );
        bk1.setContent("nguyen huu tuan.huu tuan");
        bk1.processContent();
        System.out.println(bk1);
    }
}
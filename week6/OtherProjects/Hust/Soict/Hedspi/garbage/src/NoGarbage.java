import java.io.*;
import java.util.*;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileReader fr = new FileReader("C:\\Users\\Admin\\Documents\\java\\OtherProjects\\Hust\\Soict\\Hedspi\\garbage\\src\\text.txt");
        Scanner sc = new Scanner(fr);
        StringBuffer line = new StringBuffer();
        while(sc.hasNext()){
            line.append(sc.nextLine());
            line.append("\n");
        }
        System.out.println(line);
        System.out.println(System.currentTimeMillis() - start);
        // Close the file.
        sc.close();
    }
}

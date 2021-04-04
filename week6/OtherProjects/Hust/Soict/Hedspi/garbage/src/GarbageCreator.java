import java.io.*;
import java.util.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileReader fr = new FileReader("C:\\Users\\Admin\\Documents\\java\\OtherProjects\\Hust\\Soict\\Hedspi\\garbage\\src\\text.txt");
        Scanner sc = new Scanner(fr);
        String line = "";
        while(sc.hasNext()){
            line += sc.nextLine() + "\n";
        }
        System.out.println(line);
        System.out.println(System.currentTimeMillis() - start);
        // Close the file.
        sc.close();
    }
}

import java.io.*;
import java.util.*;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Admin\\Documents\\java\\OtherProjects\\Hust\\Soict\\Hedspi\\garbage\\src\\text.txt");
        Scanner sc = new Scanner(fr);
        String line = "";
        while(sc.hasNext() == true){
            line = sc.nextLine();
            line += sc.nextLine();
        }
        System.out.println(line);
        // Close the file.
        sc.close();
    }
}

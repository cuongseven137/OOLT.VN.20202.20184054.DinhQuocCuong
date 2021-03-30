import java.io.*;
import java.util.*;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Admin\\Documents\\java\\OtherProjects\\Hust\\Soict\\Hedspi\\garbage\\src\\text.txt");
        Scanner sc = new Scanner(fr);
        StringBuffer line = new StringBuffer();
        while(sc.hasNext()){
            line.append(sc.nextLine());
            line.append("\n");
        }
        System.out.println(line);
        // Close the file.
        sc.close();
    }
}

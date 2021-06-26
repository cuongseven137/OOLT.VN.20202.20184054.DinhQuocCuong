package sample;

import algorithmg.TSP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class getCityFromFile {
    public TSP tsp;

    public getCityFromFile(int x, String location) {
        this.tsp = new TSP(x);
        tsp.TARGET = 5000;	// number for algorithm to find
        try {
            FileInputStream fileinputstream =  new FileInputStream(location);
            Scanner scan2 = new Scanner(fileinputstream);
            int i = 0;
            while (scan2.hasNextLine()) {
                String line = scan2.nextLine();
                String[] line_array = line.split(" ");
                tsp.XLocations[i] = Integer.parseInt(line_array[0]);
                tsp.YLocations[i] = Integer.parseInt(line_array[1]);
                i++;
                if(i==x) break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TSP returnTSP(){
        return this.tsp;
    }
}

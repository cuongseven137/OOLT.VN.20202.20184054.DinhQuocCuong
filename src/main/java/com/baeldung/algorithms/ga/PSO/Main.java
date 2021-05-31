package com.baeldung.algorithms.ga.PSO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
public class Main {
	 public void run(){
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Fill CITY_COUNT UNDER (CITY_COUNT is x)");
		 System.out.print("Number City: ");
		 List<Double> pick = new ArrayList<>();
		 try (Scanner scanner = new Scanner(new File("C:\\Users\\Pro\\Downloads\\test.txt"))) {
			 while (scanner.hasNext()) {
				 String s1[] = scanner.nextLine().split(" ");
				 for (String s2: s1){
					 double s3 = Double.parseDouble(s2);
					 pick.add(s3);
				 }
			 }
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }

		 TSP tsp = new TSP(pick.size()/2);
		 tsp.TARGET = 1250;	// number for algorithm to find


		 for(int k = 0; k<tsp.CITY_COUNT ; k++) {
			 tsp.XLocations[k] = pick.get(k*2);
			 tsp.YLocations[k] = pick.get(k*2 + 1);
		 }
	        tsp.initCityList();
	        tsp.PSO();
	        tsp.printBestSolution();

	}
}
*/
public class Main {
	public void run(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Fill CITY_COUNT UNDER (CITY_COUNT is x)");
		System.out.print("Number City: ");
		int x = scan.nextInt();
		TSP tsp = new TSP(x);
		tsp.TARGET = 1250;	// number for algorithm to find
		try {
			String url = "C:\\Users\\Pro\\Downloads\\test.txt";
			FileInputStream fileinputstream =  new FileInputStream(url);
			Scanner scan2 = new Scanner(fileinputstream);
			int i = 0;
			while (scan2.hasNextLine()) {
				String line = scan2.nextLine();
				String[] line_array = line.split(" ");
				tsp.XLocations[i] = Integer.parseInt(line_array[0]);
				tsp.YLocations[i] = Integer.parseInt(line_array[1]);
				i++;
			}
		}catch (Exception e)
		{
			System.out.println("Error : "+e.getMessage() +" !");
		}

		tsp.initCityList();
		tsp.PSO();
		tsp.printBestSolution();

	}
}

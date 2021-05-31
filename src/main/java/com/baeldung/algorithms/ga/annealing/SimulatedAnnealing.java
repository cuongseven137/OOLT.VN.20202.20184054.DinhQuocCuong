package com.baeldung.algorithms.ga.annealing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulatedAnnealing {

    private static Travel travel = new Travel();

    public static double simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRate) {
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
        for(int i = 0; i < pick.size() ; i = i + 2 ){
            City city = new City(pick.get(i), pick.get(i+1));
            travel.addCity(city);
        }

        System.out.println("Starting SA with temperature: " + startingTemperature + ", # of iterations: " + numberOfIterations + " and colling rate: " + coolingRate);
        double t = startingTemperature;
        // travel.generateInitialTravel();
        double bestDistance = travel.getDistance();
        System.out.println("Initial distance of travel: " + bestDistance);
        Travel bestSolution = travel;
        Travel currentSolution = bestSolution;

        for (int i = 0; i < numberOfIterations; i++) {
            if (t > 0.1) {
                currentSolution.swapCities();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
                    currentSolution.revertSwap();
                }
                t *= coolingRate;
            } else {
                continue;
            }
            if (i % 100 == 0) {
                System.out.println("Iteration #" + i);
            }
        }
        return bestDistance;
    }

}

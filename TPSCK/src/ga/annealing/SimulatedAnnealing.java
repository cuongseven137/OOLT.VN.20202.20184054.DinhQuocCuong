package ga.annealing;

import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import sample.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sample.Controller.CITY_COLOR;
import static sample.Controller.CITY_RADIUS;

public class SimulatedAnnealing {

    private static Travel travel = new Travel();

    public  SimulatedAnnealing(AnchorPane display) {
        List<Double> pick = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("C:\\Users\\Pro\\Downloads\\test.txt"))) {
            while (scanner.hasNext()) {
                String s1[] = scanner.nextLine().split(" ");
                for (String s2: s1){
                    double s3 = Double.parseDouble(s2);
                    pick.add(s3);
                    System.out.println(s3);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < pick.size() ; i = i + 2 ){
            City city = new City(pick.get(i), pick.get(i+1));
            travel.addCity(city);
            Circle cirTemp= new Circle();
            cirTemp.setCenterX(pick.get(i));
            cirTemp.setCenterY(pick.get(i+1));
            cirTemp.setFill(Color.web(CITY_COLOR));
            cirTemp.setRadius(CITY_RADIUS);
            display.getChildren().add(cirTemp);
        }

    }
    double startingTemperature=10;
    int numberOfIterations=10000;
    double coolingRate=0.9995;
    public SequentialTransition SATranslateTrans(AnchorPane display) {
        SequentialTransition sumTrans=new SequentialTransition();
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
            SequentialTransition EachRouteTrans=new SequentialTransition();
            if (i % 100 == 0) {
                System.out.println("Iteration #" + i);
                Line[] sumLineInEachRoute=new Line[currentSolution.getTravelNum()-1];
                for (int j=0;j<currentSolution.getTravelNum()-1;j++) {
                    System.out.printf("%.1f,", currentSolution.getCity(j).getX());
                    System.out.printf("%.1f;", currentSolution.getCity(j).getY());
                    sumLineInEachRoute[j]=new Line();
                    sumLineInEachRoute[j].setStartX(currentSolution.getCity(j).getX());
                    sumLineInEachRoute[j].setStartY(currentSolution.getCity(j).getY());
                    sumLineInEachRoute[j].setEndX(currentSolution.getCity(j+1).getX());
                    sumLineInEachRoute[j].setEndY(currentSolution.getCity(j+1).getY());
                    sumLineInEachRoute[j].setStroke(Color.web("#ffffff",0));
                    //sumLineInEachRoute[j].setStrokeWidth(2);
                    display.getChildren().add(sumLineInEachRoute[j]);
                }
                for (int j = 0; j < currentSolution.getTravelNum()-1; j++) {
                    StrokeTransition stroke = new StrokeTransition();
                    stroke.setAutoReverse(false);
                    stroke.setCycleCount(1);
                    stroke.setDuration(Duration.millis(Controller.DELAY_TIME));
                    stroke.setFromValue(Color.web("#ffffff",0));
                    stroke.setToValue(Color.BLACK);
                    stroke.setShape(sumLineInEachRoute[j]);
                    EachRouteTrans.getChildren().add(stroke);
                } // show
                    for (int j = 0; j < currentSolution.getTravelNum() - 1; j++) {
                        StrokeTransition stroke = new StrokeTransition();
                        stroke.setAutoReverse(false);
                        stroke.setCycleCount(1);
                        stroke.setDuration(Duration.millis(1));
                        stroke.setFromValue(Color.BLACK);
                        if(i!=9200){
                            stroke.setToValue(Color.web("#ffffff", 0));
                        }
                        else{
                            stroke.setToValue(Color.GREEN);
                        }
                        stroke.setShape(sumLineInEachRoute[j]);
                        EachRouteTrans.getChildren().add(stroke);
                    } // hide
                sumTrans.getChildren().add(EachRouteTrans);
            }
        }
        return sumTrans;
    }
}

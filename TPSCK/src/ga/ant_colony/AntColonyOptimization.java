package ga.ant_colony;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import ga.annealing.City;
import ga.annealing.Travel;
import ga.ant_colony.Ant;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import sample.Controller;

import static sample.Controller.CITY_COLOR;
import static sample.Controller.CITY_RADIUS;

public class AntColonyOptimization {

    private double c = 1.0;
    private double alpha = 1;
    private double beta = 5;
    private double evaporation = 0.5;
    private double Q = 500;
    private double antFactor = 0.8;
    private double randomFactor = 0.01;

    private int maxIterations = 1000;

    private int numberOfCities;
    private int numberOfAnts;
    private double graph[][];
    private double trails[][];
    private List<Ant> ants = new ArrayList<>();
    private Random random = new Random();
    private double probabilities[];

    private int currentIndex;
     private static Travel travel = new Travel();

    private int[] bestTourOrder;
    private double bestTourLength;

    public AntColonyOptimization(AnchorPane display) {
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
            Circle cirTemp= new Circle();
            cirTemp.setCenterX(pick.get(i));
            cirTemp.setCenterY(pick.get(i+1));
            cirTemp.setFill(Color.web(CITY_COLOR));
            cirTemp.setRadius(CITY_RADIUS);
            display.getChildren().add(cirTemp);
        }
        int noOfCities = travel.numberOfCities();
        graph = generateRandomMatrix(noOfCities);
        numberOfCities = graph.length;
        numberOfAnts = (int) (numberOfCities * antFactor);

        trails = new double[numberOfCities][numberOfCities];
        probabilities = new double[numberOfCities];
        IntStream.range(0, numberOfAnts)
            .forEach(i -> ants.add(new Ant(numberOfCities)));
    }

    /**
     * Generate initial solution
     */
    public double[][] generateRandomMatrix(int n) {
        double[][] randomMatrix = new double[n][n];
        IntStream.range(0, n)
            .forEach(i -> IntStream.range(0, n)
                .forEach(j -> randomMatrix[i][j] = Math.abs(random.nextInt(100) + 1)));
        return randomMatrix;
    }

    /**
     * Perform ant optimization
     */
    int currenIt=0;
    public SequentialTransition startAntOptimization(AnchorPane display) {
        SequentialTransition sumTrans=new SequentialTransition();
        IntStream.rangeClosed(1, 30)
            .forEach(i -> {
                currenIt++;
                System.out.println("Attempt #" + i);
                sumTrans.getChildren().add(solve(display));
            });
        return sumTrans;
    }

    /**
     * Use this method to run the main logic
     */
    public SequentialTransition solve(AnchorPane display) {
        SequentialTransition EachRouteTrans=new SequentialTransition();
        setupAnts();
        clearTrails();
        IntStream.range(0, maxIterations)
            .forEach(i -> {
                moveAnts();
                updateTrails();
                updateBest();
            });
//        System.out.println("Best tour length: " + (bestTourLength - numberOfCities));
//        System.out.println("Best tour order: " + Arrays.toString(bestTourOrder));
        Line[] sumLineInEachRoute=new Line[bestTourOrder.length-1];
        for (int j=0;j<bestTourOrder.length-1;j++) {
//            System.out.printf("%.1f,", travel.getCity(j).getX());
//            System.out.printf("%.1f;", travel.getCity(j).getY());
            sumLineInEachRoute[j]=new Line();
            sumLineInEachRoute[j].setStartX(travel.getCity(j).getX());
            sumLineInEachRoute[j].setStartY(travel.getCity(j).getY());
            sumLineInEachRoute[j].setEndX(travel.getCity(j+1).getX());
            sumLineInEachRoute[j].setEndY(travel.getCity(j+1).getY());
            sumLineInEachRoute[j].setStroke(Color.web("#ffffff",0));
            sumLineInEachRoute[j].setStrokeWidth(2);
            display.getChildren().add(sumLineInEachRoute[j]);
        }
        for (int j = 0; j < bestTourOrder.length-1; j++) {
            StrokeTransition stroke = new StrokeTransition();
            stroke.setAutoReverse(false);
            stroke.setCycleCount(1);
            stroke.setDuration(Duration.millis(Controller.DELAY_TIME));
            stroke.setFromValue(Color.web("#ffffff",0));
            stroke.setToValue(Color.BLACK);
            stroke.setShape(sumLineInEachRoute[j]);
            EachRouteTrans.getChildren().add(stroke);
        } // show
        for (int j = 0; j < bestTourOrder.length-1; j++) {
                StrokeTransition stroke = new StrokeTransition();
                stroke.setAutoReverse(false);
                stroke.setCycleCount(1);
                stroke.setDuration(Duration.millis(1));
                stroke.setFromValue(Color.BLACK);
               if(currenIt!=30) stroke.setToValue(Color.web("#ffffff", 0));
               else{
                   stroke.setToValue(Color.BLUE);
               }
                stroke.setShape(sumLineInEachRoute[j]);
                EachRouteTrans.getChildren().add(stroke);
        } // hide
        return EachRouteTrans;
    }

    /**
     * Prepare ants for the simulation
     */
    private void setupAnts() {
        IntStream.range(0, numberOfAnts)
            .forEach(i -> {
                ants.forEach(ant -> {
                    ant.clear();
                    ant.visitCity(-1, random.nextInt(numberOfCities));
                });
            });
        currentIndex = 0;
    }

    /**
     * At each iteration, move ants
     */
    private void moveAnts() {
        IntStream.range(currentIndex, numberOfCities - 1)
            .forEach(i -> {
                ants.forEach(ant -> ant.visitCity(currentIndex, selectNextCity(ant)));
                currentIndex++;
            });
    }

    /**
     * Select next city for each ant
     */
    private int selectNextCity(Ant ant) {
        int t = random.nextInt(numberOfCities - currentIndex);
        if (random.nextDouble() < randomFactor) {
            OptionalInt cityIndex = IntStream.range(0, numberOfCities)
                .filter(i -> i == t && !ant.visited(i))
                .findFirst();
            if (cityIndex.isPresent()) {
                return cityIndex.getAsInt();
            }
        }
        calculateProbabilities(ant);
        double r = random.nextDouble();
        double total = 0;
        for (int i = 0; i < numberOfCities; i++) {
            total += probabilities[i];
            if (total >= r) {
                return i;
            }
        }

        throw new RuntimeException("There are no other cities");
    }

    /**
     * Calculate the next city picks probabilites
     */
    public void calculateProbabilities(Ant ant) {
        int i = ant.trail[currentIndex];
        double pheromone = 0.0;
        for (int l = 0; l < numberOfCities; l++) {
            if (!ant.visited(l)) {
                pheromone += Math.pow(trails[i][l], alpha) * Math.pow(1.0 / graph[i][l], beta);
            }
        }
        for (int j = 0; j < numberOfCities; j++) {
            if (ant.visited(j)) {
                probabilities[j] = 0.0;
            } else {
                double numerator = Math.pow(trails[i][j], alpha) * Math.pow(1.0 / graph[i][j], beta);
                probabilities[j] = numerator / pheromone;
            }
        }
    }

    /**
     * Update trails that ants used
     */
    private void updateTrails() {
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                trails[i][j] *= evaporation;
            }
        }
        for (Ant a : ants) {
            double contribution = Q / a.trailLength(graph);
            for (int i = 0; i < numberOfCities - 1; i++) {
                trails[a.trail[i]][a.trail[i + 1]] += contribution;
            }
            trails[a.trail[numberOfCities - 1]][a.trail[0]] += contribution;
        }
    }

    /**
     * Update the best solution
     */
    private void updateBest() {
        if (bestTourOrder == null) {
            bestTourOrder = ants.get(0).trail;
            bestTourLength = ants.get(0)
                .trailLength(graph);
        }
        for (Ant a : ants) {
            if (a.trailLength(graph) < bestTourLength) {
                bestTourLength = a.trailLength(graph);
                bestTourOrder = a.trail.clone();
            }
        }
    }

    /**
     * Clear trails after simulation
     */
    private void clearTrails() {
        IntStream.range(0, numberOfCities)
            .forEach(i -> {
                IntStream.range(0, numberOfCities)
                    .forEach(j -> trails[i][j] = c);
            });
    }

}

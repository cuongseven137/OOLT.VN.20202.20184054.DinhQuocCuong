package ga.annealing;

import java.util.ArrayList;
import java.util.Collections;


public class Travel {

    private static ArrayList<City> travel = new ArrayList<>();
    private ArrayList<City> previousTravel = new ArrayList<>();

    // public Travel(int numberOfCities) {
    //     for (int i = 0; i < numberOfCities; i++) {
    //         travel.add(new City());
    //     }
    // }

    /**
     * Adds a destination city
     * @param city
     */
    public static void addCity(City city) {
        travel.add(city);
    }

    // public void generateInitialTravel() {
    //     if (travel.isEmpty())
    //         new Travel(10);
    //     Collections.shuffle(travel);
    // }
    public int getTravelNum(){
        return this.travel.size();
    }
    public int getPreviousTravelNum(){
        return this.previousTravel.size();
    }
    public static int numberOfCities(){
        return travel.size();
    }

    public void swapCities() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        previousTravel = travel;
        City x = travel.get(a);
        City y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    public void revertSwap() {
        travel = previousTravel;
    }

    private int generateRandomIndex() {
        return (int) (Math.random() * travel.size());
    }

    public City getCity(int index) {
        return travel.get(index);
    }

    public int getDistance() {
        int distance = 0;
        for (int index = 0; index < travel.size(); index++) {
            City starting = getCity(index);
            City destination;
            if (index + 1 < travel.size()) {
                destination = getCity(index + 1);
            } else {
                destination = getCity(0);
            }
            distance += starting.distanceToCity(destination);
        }
        return distance;
    }

}

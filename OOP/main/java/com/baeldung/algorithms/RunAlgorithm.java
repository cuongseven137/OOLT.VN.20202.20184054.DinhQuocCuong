package com.baeldung.algorithms;
import java.io.FileInputStream;
import java.util.Scanner;

import com.baeldung.algorithms.ga.PSO.Main;
import com.baeldung.algorithms.ga.annealing.SimulatedAnnealing;
import com.baeldung.algorithms.ga.ant_colony.AntColonyOptimization;


public class RunAlgorithm {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Scanner in = new Scanner(System.in);
		System.out.println("Run algorithm:");
		System.out.println("1 - Simulated Annealing");
		System.out.println("2 - Particle Swarm Optimization");
		System.out.println("3 - Ant Colony");
		int decision = in.nextInt();
		switch (decision) {
		case 1:
			System.out.println(
					"Optimized distance for travel: " + SimulatedAnnealing.simulateAnnealing(10, 10000, 0.9995));
			break;
		case 2:
			Main m = new Main();
			m.run();
			break;
		case 3:
			AntColonyOptimization antColony = new AntColonyOptimization();
			antColony.startAntOptimization();
			break;
		default:
			System.out.println("Unknown option");
			break;
		}
		in.close();
	}

}

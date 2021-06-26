package ga;
import java.io.FileInputStream;
import java.util.Scanner;
import ga.ant_colony.AntColonyOptimization;


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

			break;
		case 2:

			break;
		case 3:

			//antColony.startAntOptimization();
			break;
		default:
			System.out.println("Unknown option");
			break;
		}
		in.close();
	}

}

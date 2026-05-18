import java.util.*;

class AirportSimulation {
	public static void main(String[] args) {
		LinkedQueue<Plane> landingQueue = new LinkedQueue<>();
		LinkedQueue<Plane> takeOffQueue = new LinkedQueue<>();
		Random random = new Random();
		double landingRate = Double.parseDouble(args[0]);	// Uses arg indices to convert a String to a double
		double takeOffRate = Double.parseDouble(args[1]);
		double landingTime = Double.parseDouble(args[2]);
		double takeOffTime = Double.parseDouble(args[3]);
		boolean runwayBusy = false;	// false is the default for the boolean
		double runwayTimer = 0; // 0 is the default for the int values
		int currentTime = 0;
		int simulationDuration = Integer.parseInt(args[4]); // Uses an arg index to convert a String to an int
		int totalLandingWait = 0;
		int totalTakeOffWait = 0;
		int totalLanded = 0;
		int totalTakenOff = 0;
		int totalQueueLength = 0;

		for (int i = 0; i < simulationDuration; i++) {
			double random1 = random.nextDouble();	// Generates along with random2 two random numbers used for quing new planes
			double random2 = random.nextDouble();
			if (random1 < landingRate) {
				Plane plane = new Plane(currentTime);
				landingQueue.enqueue(plane);
			}
			if (random2 < takeOffRate) {
				Plane plane = new Plane(currentTime);
				takeOffQueue.enqueue(plane);
			}
			if (!runwayBusy) {	// Checks if the runway is busy then checks if the queues are empty to decide on dequing planes and modifying time and plane numbers
				if (!landingQueue.isEmpty()) {
					Plane plane = landingQueue.dequeue();
					totalLandingWait += currentTime - plane.getArrivalTime();
					runwayTimer = landingTime;
					runwayBusy = true;
					totalLanded++;
				} else if (!takeOffQueue.isEmpty()) {
					Plane plane = takeOffQueue.dequeue();
					totalTakeOffWait += currentTime - plane.getArrivalTime();
					runwayTimer = takeOffTime;
					runwayBusy = true;
					totalTakenOff++;
				}
			}
			if (runwayBusy) {
				runwayTimer = runwayTimer - 1;	// Decrements until the runway timer is 0
				if (runwayTimer == 0) {
					runwayBusy = false;
				}
			}
			totalQueueLength += landingQueue.size() + takeOffQueue.size();
			currentTime++;
		}
		System.out.println("Total planes landed: " + totalLanded);
		if (totalLanded > 0) {
			System.out.println("Average landing wait time: " + (double) totalLandingWait / totalLanded); // Double is used in the end to allow precise averages to be printed
		} else {
			System.out.println("No planes landed.");
		}
		System.out.println("Total planes taken off: " + totalTakenOff);
		if (totalTakenOff > 0) {
			System.out.println("Average takeoff wait time: " + (double) totalTakeOffWait / totalTakenOff);
		} else {
			System.out.println("No planes took off.");
		}
		System.out.println("Average queue length: " + (double) totalQueueLength / simulationDuration);
	}
}

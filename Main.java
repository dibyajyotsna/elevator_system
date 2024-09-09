import java.util.*;
public class ElevatorController {
    private Elevator elevator;             // The elevator instance being controlled
    private List<Floor> floors;            // List of floors in the building
    private Queue<Passenger> passengerQueue; // Queue of passenger requests

    // Constructor to initialize the elevator controller with the number of floors
    public ElevatorController(int numFloors) {
        elevator = new Elevator();                  // Create a new elevator instance
        floors = new ArrayList<>();                // Initialize the list of floors
        passengerQueue = new LinkedList<>();       // Initialize the passenger request queue

        // Create instances of floors and add them to the list
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    // Request an elevator from a source floor to a destination floor
    public void requestElevator(int sourceFloor, int destinationFloor) {
        Floor source = floors.get(sourceFloor - 1);           // Get the source floor object
        Floor destination = floors.get(destinationFloor - 1); // Get the destination floor object
        Passenger passenger = new Passenger(destinationFloor); // Create a new passenger with the destination floor
        passengerQueue.offer(passenger);                       // Add the passenger to the request queue

        // Determine elevator direction if it's not moving
        if (elevator.getDirection() == Directions.NONE) {
            if (sourceFloor > elevator.getCurrentFloor()) {
                elevator.direction = Directions.UP;   // Set direction to UP if source is above
            } else {
                elevator.direction = Directions.DOWN; // Set direction to DOWN if source is below
            }
        }
    }

    // Process passenger requests and move the elevator
    public void processRequests() {
        while (!passengerQueue.isEmpty()) {
            Passenger passenger = passengerQueue.poll(); // Get the next passenger request
            int destinationFloor = passenger.getDestinationFloor(); // Get the destination floor

            // Move the elevator to the requested floor
            if (destinationFloor > elevator.getCurrentFloor()) {
                elevator.moveToFloor(destinationFloor);
            } else if (destinationFloor < elevator.getCurrentFloor()) {
                elevator.moveToFloor(destinationFloor);
            }
        }
    }
}


// Main class to demonstrate the elevator simulation
public class Main {
    public static void main(String[] args) {
        // Create an ElevatorController instance with 5 floors
        ElevatorController controller = new ElevatorController(5);

        // Simulate passenger requests
        controller.requestElevator(2, 4); // Passenger requests elevator from floor 2 to 4
        controller.requestElevator(1, 5); // Passenger requests elevator from floor 1 to 5
        controller.requestElevator(4, 1); // Passenger requests elevator from floor 4 to 1

        // Process passenger requests and simulate elevator movement
        controller.processRequests();
    }
}

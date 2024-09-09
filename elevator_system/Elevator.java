public class Elevator {
        public int currentFloor;   // The current floor the elevator is on
        public Directions direction; // The direction in which the elevator is moving
    
        // Constructor to initialize the elevator's state
        public Elevator() {
            currentFloor = 1;               // Start on the first floor
            direction = Directions.NONE;     // Initially, elevator is stationary
        }
    
        // Get the current floor of the elevator
        public int getCurrentFloor() {
            return currentFloor;
        }
    
        // Get the direction in which the elevator is moving
        public Directions getDirection() {
            return direction;
        }
    
        // Move the elevator to the specified target floor
        public void moveToFloor(int targetFloor) {
            System.out.println("Elevator moving " + direction + " from floor " + currentFloor + " to floor " + targetFloor);
            currentFloor = targetFloor;     // Update the current floor to the target floor
        }
    }
    


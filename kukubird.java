package wowix;
import java.util.Scanner;	
public class kukubird {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] hotel = new int[7][5];
        boolean running = true;

        while (running) {
         
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. View Rooms");
            System.out.println("2. Check In");
            System.out.println("3. Check Out");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                   
                    displayRooms(hotel);
                    break;

                case 2:
                  
                    System.out.print("Enter floor (1-7): ");
                    int checkInFloor = sc.nextInt();
                    System.out.print("Enter room (1-5): ");
                    int checkInRoom = sc.nextInt();
                    if (isValidRoom(checkInFloor, checkInRoom)) {
                        if (hotel[checkInFloor - 1][checkInRoom - 1] == 0) {
                            hotel[checkInFloor - 1][checkInRoom - 1] = 1;
                            System.out.println("Check-in successful!");
                        } else {
                            System.out.println("Room already occupied!");
                        }
                    } else {
                        System.out.println("Invalid floor or room number!");
                    }
                    break;

                case 3:
          
                    System.out.print("Enter floor (1-7): ");
                    int checkOutFloor = sc.nextInt();
                    System.out.print("Enter room (1-5): ");
                    int checkOutRoom = sc.nextInt();
                    if (isValidRoom(checkOutFloor, checkOutRoom)) {
                        if (hotel[checkOutFloor - 1][checkOutRoom - 1] == 1) {
                            hotel[checkOutFloor - 1][checkOutRoom - 1] = 0;
                            System.out.println("Check-out successful!");
                        } else {
                            System.out.println("Room already empty!");
                        }
                    } else {
                        System.out.println("Invalid floor or room number!");
                    }
                    break;

                case 4:
  
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }


    public static void displayRooms(int[][] hotel) {
        System.out.println("\nRoom Status (0=Available, 1=Occupied):");
        for (int floor = hotel.length - 1; floor >= 0; floor--) {
            System.out.print("Floor " + (floor + 1) + ": ");
            for (int room = 0; room < hotel[floor].length; room++) {
                System.out.print("[" + hotel[floor][room] + "]");
            }
            System.out.println();
        }
    }


    public static boolean isValidRoom(int floor, int room) {
        return (floor >= 1 && floor <= 7) && (room >= 1 && room <= 5);
    }
}


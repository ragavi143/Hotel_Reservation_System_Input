import java.util.*;

class Room {
    int roomNo;
    String roomType;
    boolean booked;
    String customerName;
    int days;

    Room(int roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.booked = false;
        this.customerName = "";
        this.days = 0;
    }
}

public class HotelReservationSystemInput {

    static Room[] rooms = {
            new Room(101, "Single"),
            new Room(102, "Single"),
            new Room(201, "Double"),
            new Room(202, "Double"),
            new Room(301, "Deluxe")
    };

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View Rooms");
            System.out.println("4. View Customer Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bookRoom();
                    break;

                case 2:
                    cancelRoom();
                    break;

                case 3:
                    viewRooms();
                    break;

                case 4:
                    customerDetails();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void bookRoom() {

        viewRooms();

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();
        sc.nextLine();

        for (Room room : rooms) {

            if (room.roomNo == roomNo) {

                if (!room.booked) {

                    System.out.print("Enter Customer Name: ");
                    room.customerName = sc.nextLine();

                    System.out.print("Number of Days: ");
                    room.days = sc.nextInt();

                    room.booked = true;

                    double bill = calculateBill(room);

                    System.out.println("Room Booked Successfully");
                    System.out.println("Total Bill = Rs." + bill);

                } else {
                    System.out.println("Room Already Booked");
                }
                return;
            }
        }

        System.out.println("Room Not Found");
    }

    static void cancelRoom() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNo == roomNo) {

                room.booked = false;
                room.customerName = "";
                room.days = 0;

                System.out.println("Booking Cancelled");
                return;
            }
        }

        System.out.println("Room Not Found");
    }

    static void viewRooms() {

        System.out.println("\nRoom Status");

        for (Room room : rooms) {

            System.out.println(
                    room.roomNo + " | " +
                    room.roomType + " | " +
                    (room.booked ? "Booked" : "Available"));
        }
    }

    static void customerDetails() {

        System.out.println("\nCustomer Details");

        for (Room room : rooms) {

            if (room.booked) {

                System.out.println(
                        "Room: " + room.roomNo +
                        ", Name: " + room.customerName +
                        ", Days: " + room.days);
            }
        }
    }

    static double calculateBill(Room room) {

        int rate = 0;

        switch (room.roomType) {

            case "Single":
                rate = 1000;
                break;

            case "Double":
                rate = 2000;
                break;

            case "Deluxe":
                rate = 3500;
                break;
        }

        return rate * room.days;
    }
}
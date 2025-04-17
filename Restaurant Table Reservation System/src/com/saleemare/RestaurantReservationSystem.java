package src.com.saleemare;

public class RestaurantReservationSystem {
    public static void main(String[] args) {
        ReservationManager manager = new ReservationManager();
        InputHandler input = new InputHandler();

        manager.loadReservations();

        while (true) {
        	System.out.println("\n==============================");
            System.out.println("   Welcome to Sale e Mare 🍽️");
            System.out.println("   Dinner starts at 6:00 PM");
            System.out.println("==============================");
            System.out.println("1. Show Available Tables");
            System.out.println("2. Add Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");

            int choice = input.getIntInput("Enter choice (1-5): ", 1, 5); // ตรวจสอบให้เลือกได้แค่ 1-5

                if (choice == 1) {
                manager.showAvailableTables(); 
                }
                
                else if (choice == 2) {
                int type = input.getIntInput("Select table type: 1 = Regular, 2 = VIP: ", 1, 2);

                int tableNumber;
                if (type == 1) {
                    tableNumber = input.getIntInput("Enter table number for Regular Table (6–20): ", 6, 20);
                } else {
                    tableNumber = input.getIntInput("Enter table number for VIP Table (1–5): ", 1, 5);
                }
             
                // Check if the table is already booked
                if (manager.isTableBooked(tableNumber)) {
                    System.out.println("⚠️ This table has already been booked. Please choose another table.");
                    continue;  // Allow user to choose another table
                }

                String name = input.getValidatedName("Enter customer name: ");
                int capacity = 4;  // fixed dinner style

                String id = "R" + tableNumber;

                Table table = (type == 1)
                        ? new RegularTable(tableNumber, capacity)
                        : new VIPTable(tableNumber, capacity);

                Reservation r = new Reservation(id, table, name);
                manager.addReservation(tableNumber, r);

                System.out.println("✅ Reservation completed for " + name + " at Table #" + tableNumber);
                System.out.println("Please ensure your arrival before 7:00 PM. Any reservations not claimed by this time will be automatically cancelled.");
            

            } else if (choice == 3) {
                int tableNumber = input.getIntInput("Enter table number to cancel: ", 1, 20);
                manager.cancelReservation(tableNumber);
            } else if (choice == 4) {
                String name = input.getValidatedName("Enter your name to view reservation: ");
                manager.showReservationsByName(name);
            }
            else if (choice == 5) {
                manager.saveReservations();
                break; 
                }
        }
    }
}

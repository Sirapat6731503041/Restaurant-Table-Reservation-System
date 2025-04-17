import java.io.*;
import java.util.HashMap;

/**
 * This class manages reservations using a HashMap (Collection).
 * It demonstrates file I/O (read/write to file) and exception handling.
 */
public class ReservationManager {
    private HashMap<Integer, Reservation> reservations = new HashMap<>();

    public void showAvailableTables() {
        System.out.println("\n=== Available Tables ===");

        for (int i = 1; i <= 5; i++) {
            if (!reservations.containsKey(i)) {
                System.out.println("Table " + i + " (VIP)");
            }
        }

        for (int i = 6; i <= 20; i++) {
            if (!reservations.containsKey(i)) {
                System.out.println("Table " + i + " (Regular)");
            }
        }

        System.out.println("------------------------");
    }
    
    // Add a reservation for a specific table number
    public void addReservation(int tableNumber, Reservation reservation) {
        reservations.put(tableNumber, reservation);
        System.out.println("Reservation added for " + reservation.getCustomerName());
    }

    // Cancel a reservation based on table number
    public void cancelReservation(int tableNumber) {
        if (reservations.containsKey(tableNumber)) {
            reservations.remove(tableNumber);
            System.out.println("Reservation canceled.");
        } else {
            System.out.println("No reservation found.");
        }
    }

    /**
     * Save reservations to a file.
     * Demonstrates File I/O and exception handling.
     */
    public void saveReservations() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("reservations.txt"))) {
            for (Reservation r : reservations.values()) {
                // Save necessary data in CSV format
                writer.println(r.getReservationId() + "," +
                        r.getTable().getTableNumber() + "," +
                        r.getTable().getCapacity() + "," +
                        (r.getTable() instanceof VIPTable ? "VIP" : "Regular") + "," +
                        r.getCustomerName());
            }
            System.out.println("Reservations saved.");
        } catch (IOException e) {
            System.out.println("Error saving reservations: " + e.getMessage());
        }
    }

    /**
     * Load reservations from a file.
     * Demonstrates File I/O and exception handling.
     */
    public void loadReservations() {
        try (BufferedReader reader = new BufferedReader(new FileReader("reservations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the CSV line into parts
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String id = parts[0];
                int tableNumber = Integer.parseInt(parts[1]);
                int capacity = Integer.parseInt(parts[2]);
                String type = parts[3];
                String name = parts[4];

                // Use inheritance and polymorphism here
                Table table = type.equalsIgnoreCase("VIP")
                        ? new VIPTable(tableNumber, capacity)
                        : new RegularTable(tableNumber, capacity);

                Reservation reservation = new Reservation(id, table, name);
                reservations.put(tableNumber, reservation);
            }
            System.out.println("Reservations loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing reservations file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading reservations: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data format error: " + e.getMessage());
        }
    }
    
    public int getVIPReservationCount() {
        int count = 0;
        for (Reservation r : reservations.values()) {
            if (r.getTable() instanceof VIPTable) {
                count++;
            }
        }
        return count;
    }
    
    public Reservation getTable(int tableNumber) {
        return reservations.get(tableNumber);
    }
    
    public boolean isTableBooked(int tableNumber) {
        return reservations.containsKey(tableNumber);
    }
    
    
    // Filters data from the Collection (HashMap) to display only the user's own reservations
    // Enhances data privacy and security by preventing access to other users' information
    public void showReservationsByName(String name) {
        boolean found = false;
        for (Reservation reservation : reservations.values()) {
            if (reservation.getCustomerName().equalsIgnoreCase(name)) {
                Table table = reservation.getTable();
                System.out.println("\n--- Your Reservation ---");
                System.out.println("Reservation ID: " + reservation.getReservationId());
                System.out.println("Table Number: " + table.getTableNumber());
                System.out.println("Capacity: " + table.getCapacity() + " person(s)");
                System.out.println("Service Fee: " + table.calculateServiceFee());
                System.out.println("----------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No reservation found under the name: " + name);
        }
    }
}

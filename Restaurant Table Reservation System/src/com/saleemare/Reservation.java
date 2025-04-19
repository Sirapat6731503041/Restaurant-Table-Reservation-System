// Polymorphism is used here to allow different types of tables (VIP or Regular) to be stored in a single Table reference.
package src.com.saleemare;
public class Reservation {
    private String reservationId;
    private Table table; 
    private String customerName;

    public Reservation(String reservationId, Table table, String customerName) {
        this.reservationId = reservationId;
        this.table = table;
        this.customerName = customerName;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Table getTable() {
        return table;
    }

    public String getCustomerName() {
        return customerName;
    }
}

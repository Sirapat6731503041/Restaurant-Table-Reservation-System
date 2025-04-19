package src.com.saleemare;
// Inheritance is used to inherit common properties from the Table superclass.
public class VIPTable extends Table {
    public VIPTable(int tableNumber, int capacity) {
        super(tableNumber, capacity);
    }

    @Override
    public double calculateServiceFee() {
        return 100.0;  //VIP table service fee
    }
}

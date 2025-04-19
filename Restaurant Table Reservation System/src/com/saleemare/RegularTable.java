package src.com.saleemare;
// Inheritance is used to inherit common properties from the Table superclass.
public class RegularTable extends Table {
    public RegularTable(int tableNumber, int capacity) {
        super(tableNumber, capacity);
    }

    @Override
    public double calculateServiceFee() {
        return 0.0;  //Regular tables have no service fee
    }
}

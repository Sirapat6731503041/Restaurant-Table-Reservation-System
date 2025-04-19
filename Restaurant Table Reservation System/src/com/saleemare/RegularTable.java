package src.com.saleemare;
public class RegularTable extends Table {
    public RegularTable(int tableNumber, int capacity) {
        super(tableNumber, capacity);
    }

    @Override
    public double calculateServiceFee() {
        return 0.0;  //Regular tables have no service fee
    }
}

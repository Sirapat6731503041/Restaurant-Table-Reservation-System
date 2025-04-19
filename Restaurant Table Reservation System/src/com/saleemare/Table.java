package src.com.saleemare;
public abstract class Table {
    protected int tableNumber;
    protected int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract double calculateServiceFee();  //Subclass define
}

package src.com.saleemare;
public class VIPTable extends Table {
    public VIPTable(int tableNumber, int capacity) {
        super(tableNumber, capacity);
    }

    @Override
    public double calculateServiceFee() {
        return 100.0;  // ค่าบริการสำหรับโต๊ะ VIP
    }
}

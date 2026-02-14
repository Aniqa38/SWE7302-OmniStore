package refactored.discount;

public class BulkDiscount implements DiscountStrategy {

    @Override
    public int applyDiscount(int total) {

        if (total > 2000) {
            System.out.println("Bulk discount applied: 200");
            return total - 200;
        }

        return total;
    }
}


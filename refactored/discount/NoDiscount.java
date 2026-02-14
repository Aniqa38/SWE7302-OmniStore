package refactored.discount;

public class NoDiscount implements DiscountStrategy {

    @Override
    public int applyDiscount(int total) {
        return total;
    }
}


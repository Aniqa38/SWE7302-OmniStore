package refactored.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BulkDiscountTest {

    private final DiscountStrategy discount = new BulkDiscount();

    @Test
    void appliesDiscountWhenTotalIsAbove2000() {
        assertEquals(2300, discount.applyDiscount(2500));
    }

    @Test
    void noDiscountWhenTotalIsExactly2000() {
        assertEquals(2000, discount.applyDiscount(2000));
    }

    @Test
    void noDiscountWhenTotalIsBelow2000() {
        assertEquals(1500, discount.applyDiscount(1500));
    }

    @Test
    void noDiscountStrategyLeavesTotalUnchanged() {
        assertEquals(2500, new NoDiscount().applyDiscount(2500));
    }
}

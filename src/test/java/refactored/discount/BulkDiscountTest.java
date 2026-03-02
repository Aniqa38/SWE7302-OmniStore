package refactored.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BulkDiscountTest {

    @Test
    void shouldApplyBulkDiscountWhenTotalAbove2000() {
        DiscountStrategy discount = new BulkDiscount();
        int result = discount.applyDiscount(3000);
        assertEquals(2800, result);
    }

    @Test
    void shouldNotApplyDiscountWhenTotalBelowThreshold() {
        DiscountStrategy discount = new BulkDiscount();
        int result = discount.applyDiscount(1500);
        assertEquals(1500, result);
    }

    @Test
    void shouldNotApplyDiscountWhenTotalExactly2000() {
        DiscountStrategy discount = new BulkDiscount();
        int result = discount.applyDiscount(2000);
        assertEquals(2000, result);
    }
}

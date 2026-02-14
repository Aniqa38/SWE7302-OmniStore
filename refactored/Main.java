package refactored;

import refactored.payment.*;
import refactored.discount.*;

public class Main {

    public static void main(String[] args) {

        int pricePerItem = 1000;
        int quantity = 3;
        int total = pricePerItem * quantity;

        // Strategy Pattern
        DiscountStrategy discount = new BulkDiscount();
        total = discount.applyDiscount(total);

        // Factory Pattern
        Payment payment = PaymentFactory.createPayment("CreditCard");
        payment.pay(total);
    }
}



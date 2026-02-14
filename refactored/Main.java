package refactored;

import refactored.payment.*;
import refactored.discount.*;
import refactored.order.*;

public class Main {

    public static void main(String[] args) {

        int pricePerItem = 1000;
        int quantity = 3;
        int total = pricePerItem * quantity;

        // Strategy Pattern
        DiscountStrategy discount = new BulkDiscount();
        total = discount.applyDiscount(total);

        // Decorator Pattern
        Order order = new BasicOrder(total);
        order = new GiftWrapDecorator(order);

        System.out.println("Order Description: " + order.getDescription());
        System.out.println("Final Cost: " + order.getCost());

        // Factory Pattern
        Payment payment = PaymentFactory.createPayment("CreditCard");
        payment.pay(order.getCost());
    }
}



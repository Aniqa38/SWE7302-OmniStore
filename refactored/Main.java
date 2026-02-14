package refactored;

import refactored.payment.*;

public class Main {

    public static void main(String[] args) {

        Payment payment1 = PaymentFactory.createPayment("CreditCard");
        payment1.pay(1000);

        Payment payment2 = PaymentFactory.createPayment("PayPal");
        payment2.pay(500);
    }
}


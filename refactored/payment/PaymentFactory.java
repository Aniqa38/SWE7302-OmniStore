package refactored.payment;

public class PaymentFactory {

    public static Payment createPayment(String type) {

        if (type.equalsIgnoreCase("CreditCard")) {
            return new CreditCardPayment();
        }
        else if (type.equalsIgnoreCase("PayPal")) {
            return new PayPalPayment();
        }
        else {
            throw new IllegalArgumentException("Invalid payment type");
        }
    }
}


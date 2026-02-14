package refactored.payment;

public class PayPalPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}


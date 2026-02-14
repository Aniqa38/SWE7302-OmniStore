package refactored.payment;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

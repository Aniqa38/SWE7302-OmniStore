package legacy;

import java.util.ArrayList;

public class OmniStoreManager {

    private ArrayList<String> products = new ArrayList<>();
    private ArrayList<String> customers = new ArrayList<>();

    public OmniStoreManager() {
        // Hardcoded products
        products.add("Laptop-1000");
        products.add("Phone-500");
        products.add("Tablet-700");
    }

    public void addCustomer(String name) {
        customers.add(name);
        System.out.println("Customer added: " + name);
    }

    public void placeOrder(String customerName, String productName, int quantity, String paymentType) {

        System.out.println("\nProcessing Order...");
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + quantity);

        int price = 0;

        // Hardcoded product price logic
        for (String product : products) {
            String[] parts = product.split("-");
            if (parts[0].equalsIgnoreCase(productName)) {
                price = Integer.parseInt(parts[1]);
            }
        }

        int total = price * quantity;

        // Hardcoded discount logic
        if (total > 2000) {
            total = total - 200;
            System.out.println("Bulk discount applied: 200");
        }

        // Hardcoded payment logic (BIG IF-ELSE BLOCK)
        if (paymentType.equalsIgnoreCase("CreditCard")) {
            System.out.println("Processing Credit Card payment...");
        } 
        else if (paymentType.equalsIgnoreCase("PayPal")) {
            System.out.println("Processing PayPal payment...");
        } 
        else if (paymentType.equalsIgnoreCase("Crypto")) {
            System.out.println("Processing Crypto payment...");
        } 
        else {
            System.out.println("Invalid payment method!");
            return;
        }

        // Hardcoded notification
        System.out.println("Sending email confirmation to " + customerName);

        System.out.println("Total Paid: " + total);
        System.out.println("Order Completed!\n");
    }

    public static void main(String[] args) {

        OmniStoreManager store = new OmniStoreManager();

        store.addCustomer("Alice");
        store.placeOrder("Alice", "Laptop", 3, "CreditCard");

        store.addCustomer("Bob");
        store.placeOrder("Bob", "Phone", 1, "PayPal");
    }
}

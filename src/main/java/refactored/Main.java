package refactored;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import refactored.database.DatabaseManager;
import refactored.database.DatabaseSetup;
import refactored.discount.BulkDiscount;
import refactored.discount.DiscountStrategy;
import refactored.order.BasicOrder;
import refactored.order.GiftWrapDecorator;
import refactored.order.Order;
import refactored.payment.Payment;
import refactored.payment.PaymentFactory;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Ensure table exists
        DatabaseSetup.createTable();

        Label resultLabel = new Label("Click 'Process Order' to create order");

        Button processButton = new Button("Process Order");

        processButton.setOnAction(e -> {

            // Sample data (you can later replace with TextFields)
            int pricePerItem = 1000;
            int quantity = 3;
            int total = pricePerItem * quantity;

            // Strategy Pattern
            DiscountStrategy discount = new BulkDiscount();
            total = discount.applyDiscount(total);

            // Decorator Pattern
            Order order = new BasicOrder(total);
            order = new GiftWrapDecorator(order);

            // Factory Pattern
            Payment payment = PaymentFactory.createPayment("CreditCard");
            payment.pay(order.getCost());

            // Insert into Database
            DatabaseManager.insertOrder(
                    order.getDescription(),
                    order.getCost(),
                    "CreditCard"
            );

            // Update UI
            resultLabel.setText(
                    "Order: " + order.getDescription() +
                    "\nFinal Cost: " + order.getCost()
            );

            // Success Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Order saved successfully!");
            alert.showAndWait();
        });

        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(resultLabel, processButton);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("OmniStore GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

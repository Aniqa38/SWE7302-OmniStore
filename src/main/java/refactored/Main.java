package refactored;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import refactored.database.DatabaseManager;
import refactored.database.DatabaseSetup;
import refactored.discount.BulkDiscount;
import refactored.discount.DiscountStrategy;
import refactored.discount.NoDiscount;
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

        // ===== UI COMPONENTS =====

        Label titleLabel = new Label("OmniStore Order System");

        // Price
        Label priceLabel = new Label("Price Per Item:");
        TextField priceField = new TextField();
        priceField.setPromptText("Enter price");

        // Quantity
        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter quantity");

        // Strategy - Discount
        Label discountLabel = new Label("Select Discount:");
        ComboBox<String> discountBox = new ComboBox<>();
        discountBox.getItems().addAll("No Discount", "Bulk Discount");
        discountBox.setValue("No Discount");

        // Decorator - Gift Wrap
        CheckBox giftWrapBox = new CheckBox("Add Gift Wrap");

        // Factory - Payment
        Label paymentLabel = new Label("Select Payment Method:");
        ComboBox<String> paymentBox = new ComboBox<>();
        paymentBox.getItems().addAll("CreditCard", "PayPal");
        paymentBox.setValue("CreditCard");

        Button processButton = new Button("Process Order");

        Label resultLabel = new Label();

        // ===== BUTTON ACTION =====

        processButton.setOnAction(e -> {

            try {
                int pricePerItem = Integer.parseInt(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                int total = pricePerItem * quantity;

                // ===== STRATEGY =====
                DiscountStrategy discount;

                if (discountBox.getValue().equals("Bulk Discount")) {
                    discount = new BulkDiscount();
                } else {
                    discount = new NoDiscount();
                }

                total = discount.applyDiscount(total);

                // ===== DECORATOR =====
                Order order = new BasicOrder(total);

                if (giftWrapBox.isSelected()) {
                    order = new GiftWrapDecorator(order);
                }

                // ===== FACTORY =====
                Payment payment = PaymentFactory.createPayment(paymentBox.getValue());
                payment.pay(order.getCost());

                // ===== DATABASE INSERT =====
                DatabaseManager.insertOrder(
                        order.getDescription(),
                        order.getCost(),
                        paymentBox.getValue()
                );

                // ===== UPDATE UI =====
                resultLabel.setText(
                        "Order: " + order.getDescription() +
                        "\nFinal Cost: " + order.getCost()
                );

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Order processed and saved successfully!");
                alert.showAndWait();

            } catch (NumberFormatException ex) {

                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Input Error");
                error.setHeaderText(null);
                error.setContentText("Please enter valid numeric values.");
                error.showAndWait();
            }
        });

        // ===== LAYOUT =====

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                titleLabel,
                priceLabel,
                priceField,
                quantityLabel,
                quantityField,
                discountLabel,
                discountBox,
                giftWrapBox,
                paymentLabel,
                paymentBox,
                processButton,
                resultLabel
        );

        Scene scene = new Scene(root, 400, 500);

        stage.setTitle("OmniStore GUI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
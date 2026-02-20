package refactored.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("OmniStore GUI");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter Order Amount");

        Button button = new Button("Click Me");

        Label result = new Label();

        button.setOnAction(e -> {
            result.setText("Working!");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(title, amountField, button, result);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("OmniStore");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
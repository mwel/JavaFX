package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Counter extends Application {

    private int counter;
    private Label counterLabel;

    @Override
    public void start(Stage primaryStage) {

        Insets padding = new Insets(10);

        counterLabel = new Label("Counter Value: ");
        Label counterValue = new Label();

        Button incrementButton = new Button("Increment");
        incrementButton.setOnAction(e -> increment());

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> reset());

        VBox root = new VBox();
        root.setPadding(padding);

        root.getChildren().add(counterLabel);
        root.getChildren().add(counterValue);
        root.getChildren().add(incrementButton);
        root.getChildren().add(resetButton);

        reset();

        Scene scene = new Scene(root, 100, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple JavaFX Counter");
        primaryStage.show();
    }

    public void increment() {

        counter++;
        counterLabel.setText("" + counter);

    }

    public void reset() {

        counter = 0;
        counterLabel.setText("" + counter);

    }

    public static void main(String[] args) {

        launch();
    }
}

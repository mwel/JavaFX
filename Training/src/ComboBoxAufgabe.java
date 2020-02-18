import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ComboBoxAufgabe extends Application {

    Group root;

    ComboBox comboBox;

    Label choiceLabel;

    @Override
    public void start(Stage primaryStage) {

        root = new Group();

        comboBox = new ComboBox();
        comboBox.setLayoutX(20);
        comboBox.setLayoutY(20);

        choiceLabel = new Label("Mr. Bean has not decided, yet.");
        choiceLabel.setLayoutX(10);
        choiceLabel.setLayoutY(50);

        comboBox.setPromptText("Choose drink . . .");
        comboBox.getItems().addAll("Water", "Beer", "Apple Juice", "Coffee");

        comboBox.setOnAction(event -> printChoice());

        root.getChildren().addAll(comboBox, choiceLabel);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Drink Selection for Mr. Beans / ComboBox Aufgabe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void printChoice() {

        System.out.println("Mr. Beans wants " + comboBox.getValue() + ".");
        choiceLabel.setText("Mr. Beans wants " + comboBox.getValue() + ".");
    }

    public static void main(String[] args) {
        launch();
    }
}

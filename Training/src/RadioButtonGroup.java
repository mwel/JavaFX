import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonGroup extends Application {

    Group root;
    VBox toggleBox;

    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;

    ToggleGroup radioButtonGroup;

    Label label;


    public void start(Stage primaryStage) {

        root = new Group();

        label = new Label("No button selected.");
        label.setLayoutX(30);
        root.getChildren().add(label);

        toggleBox = new VBox();

        radioButtonGroup = new ToggleGroup();

        radioButton1 = new RadioButton("1");
        radioButton2 = new RadioButton("2");
        radioButton3 = new RadioButton("3");
        radioButton4 = new RadioButton("4");
        radioButton5 = new RadioButton("5");
        radioButton6 = new RadioButton("6");

        radioButtonGroup.getToggles().addAll(radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6);

        toggleBox.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6);

        radioButtonGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> printColor());

        root.getChildren().add(toggleBox);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Radio Button Group");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void printColor() {

        RadioButton selectedRadioButton = (RadioButton) radioButtonGroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        System.out.println("Selected Button: " + toogleGroupValue);
        label.setText("Button selected: " + toogleGroupValue);
    }

    public static void main(String[] args) {
        launch();
    }

}

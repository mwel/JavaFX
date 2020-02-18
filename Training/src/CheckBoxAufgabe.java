import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;


public class CheckBoxAufgabe extends Application {
    public void start(Stage primaryStage) {

        Group root = new Group();

        CheckBox checkBox = new CheckBox("FOPT Fan");

        checkBox.selectedProperty().addListener((ov, old_val, new_val) -> hurraSchade(new_val));

        root.getChildren().add(checkBox);

        Scene scene = new Scene(root);

        primaryStage.setTitle("FOPT IS TOP / CheckBox Aufgabe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void hurraSchade(Boolean checkBoxState) {
        if (checkBoxState) {
            System.out.println("FOPT is geil!");
        } else {
            System.out.println("FOPT is der Horror!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
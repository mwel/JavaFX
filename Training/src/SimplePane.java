import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SimplePane extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        for (int i = 1; i < 20; i++) {

            Button button = new Button("Button" + i);
            button.setLayoutX(i * 20);
            button.setLayoutY(i * 20);

            root.getChildren().add(button);

        }

        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setScene(scene);
        primaryStage.setTitle("My Simple Button Pane");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    // Start Methode überschreiben
    public void start(Stage primaryStage) {

        // Elemente anlegen
        Label label1 = new Label("Hello");
        Label label2 = new Label("JavaFX");

        // Root erstellen
        VBox root = new VBox();

        // Elemente zu root hinzufügen
        root.getChildren().add(label1);
        root.getChildren().add(label2);

        //Scene erstellen und root sowie Fenstergröße übergeben
        Scene scene = new Scene(root, 100, 100);

        // Die Scene auf die Bühne bringen => scene an stage übergeben
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.show();


    }

    // Das ganze starten
    public static void main(String[] args) {

        launch();
    }
}

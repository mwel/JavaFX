package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application {

    @Override
    public void start(Stage stage) {

        // Titel des Fensters
        stage.setTitle("Access Control");

        // Grid Pane wird erzeugt und konfiguriert.
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setHgap(5); // Horizontale Abstände zwischen den Elementen
        gridPane.setVgap(5); // Vertikale Abstände zwischen den Elementen

        // Headline
        Text title = new Text("Access Control");
        title.setFont(Font.font("Helvetica Neue", FontWeight.BOLD, 25));
        gridPane.add(title, 0, 0, 2, 1); // add title to grid Pane to be displayed

        // User name label
        Label username = new Label("Username");
        gridPane.add(username, 0, 1);

        // User name Entry field
        TextField entryUsername = new TextField();
        gridPane.add(entryUsername, 1, 1);

        // Password
        Label password = new Label("Password");
        gridPane.add(password, 0, 2);

        // Password Entry
        TextField entryPassword = new TextField();
        gridPane.add(entryPassword, 1, 2);

        // Submit Button
        Button submit = new Button("Access");
        gridPane.add(submit, 1, 3);

        // Confirmation Message
        Text confirmation = new Text();
        gridPane.add(confirmation, 0, 5);


        // onAction for Submit Button
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (entryUsername.getText().equals("admin") && entryPassword.getText().equals("123456")) {
                    confirmation.setText("ACCESS GRANTED");
                }
            }
        });

        // IMMER AM SCHLUSS
        // Scene wird erzeugt, befüllt und konfiguriert, auf die Bühne gebracht und gespielt
        Scene scene = new Scene(gridPane, 500, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}

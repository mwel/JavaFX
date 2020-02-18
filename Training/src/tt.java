import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class tt extends Application {

    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();


        Button butt = new Button("Oben");
        root.setTop(butt);

        butt.setOnAction((event) ->
        {
            System.out.println("Oben gedrückt");
        });


        Button buttt = new Button("links");
        root.setLeft(buttt);

        buttt.setOnAction((event) ->
        {
            System.out.println("Links gedrückt");
        });

        Button buttc = new Button("Center");
        root.setCenter(buttc);

        buttc.setOnAction((event) ->
        {
            System.out.println("Center gedrückt");
        });


        Button buttu = new Button("Unten");
        root.setBottom(buttu);

        buttu.setOnAction((event) ->
        {
            System.out.println("Unten gedrückt");
        });


        Button buttr = new Button("Rechts");
        root.setRight(buttr);

        buttr.setOnAction((event) ->
        {
            System.out.println("Rechts gedrückt");
        });


        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("JavaFX Anwendung");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch();
    }
}
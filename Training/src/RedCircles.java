import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RedCircles extends Application {

    private static final double RADIUS = 20;
    private Pane graphicsPane;
    private Circle c;

    @Override
    public void start(Stage primaryStage) {

        graphicsPane = new Pane();

        graphicsPane.setOnMousePressed(e -> {

            c = new Circle(e.getX(), e.getY(), RADIUS);
            c.setStroke(Color.RED);
            c.setFill(null);
            graphicsPane.getChildren().add(c);

        });
        graphicsPane.setOnMouseDragged(e -> {
            c.setCenterX(e.getX());
            c.setCenterY(e.getY());
        });

        graphicsPane.setOnMouseReleased(e -> {
            c.setFill(Color.RED);
        });


        primaryStage.setTitle("Red Circles");
        primaryStage.setScene(new Scene(graphicsPane, 350, 120));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
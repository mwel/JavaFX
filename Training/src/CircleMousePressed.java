import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleMousePressed extends Application {
    public static void main(String[] args) {
        launch();
    }

    private Pane pane;
    private Circle circle;

    public void start(Stage stage) {
        pane = new Pane();
        circle = new Circle();
        final int[] i = {0};
        pane.setOnMousePressed(e -> {
                    circle.setCenterX(e.getX());
                    circle.setCenterY(e.getY());
                    circle.setRadius(i[0]++);
                }
        );
        pane.setOnMouseDragged(e -> {
                    circle.setCenterX(e.getX());
                    circle.setCenterY(e.getY());
                    circle.setRadius(i[0]++);
                }
        );
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Circle growing with MouseDragged");
        stage.show();
    }
}
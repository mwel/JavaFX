import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class graphicSlider extends Application {

    private Pane root;
    private Rectangle sliderRectangle;
    private Button reduceButton;

    private double currentPosX = 0.0;
    private double currentPosY = 0.0;
    private double height = 50;
    private double width = 20;

    public void start(Stage primaryStage) {

        root = new Pane();

        sliderRectangle = new Rectangle(0, 0, width, height);

        root.setOnMouseDragged(event -> changeSlider(event.getX(), event.getY()));

        root.getChildren().add(sliderRectangle);
        Scene scene = new Scene(root, 1200, 200);
        primaryStage.setTitle("Graphic Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeSlider(double x, double y) {

        if (x <= width && y <= height) {

            if (x < currentPosX) {
                sliderRectangle.setWidth(width--);
            } else {
                sliderRectangle.setWidth(width++);
            }
            currentPosX = x;
            currentPosY = y;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

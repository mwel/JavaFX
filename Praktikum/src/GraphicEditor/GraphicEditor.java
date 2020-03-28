package GraphicEditor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class GraphicEditor extends Application {

    VBox root;
    HBox radioButtonBox;
    Pane graphicsPane;
    HBox valueBox;

    Line line;
    Rectangle rectangle;
    Circle circle;

    ToggleGroup radioButtonGroup;
    RadioButton lineButton;
    RadioButton rectangleButton;
    RadioButton circleButton;

    Button clearButton;

    Insets padding = new Insets(10);

    @Override
    public void start(Stage primaryStage) {

        root = new VBox(10);
        radioButtonBox = new HBox(10);
        radioButtonBox.setPadding(padding);

        radioButtonGroup = new ToggleGroup();
        lineButton = new RadioButton("Line");
        rectangleButton = new RadioButton("Rectangle");
        circleButton = new RadioButton("Circle");

        radioButtonGroup.getToggles().addAll(lineButton, rectangleButton, circleButton);
        radioButtonBox.getChildren().addAll(lineButton, rectangleButton, circleButton);

        lineButton.selectedProperty().setValue(true);

        graphicsPane = new Pane();
        graphicsPane.setPrefSize(550, 300);
        graphicsPane.setPadding(padding);

        valueBox = new HBox(10);

        graphicsPane.setOnMousePressed(event -> selectShapeOnMousePressed(event.getX(), event.getY()));
        graphicsPane.setOnMouseDragged(event -> selectShapeOnMouseDragged(event.getX(), event.getY()));
        graphicsPane.setOnMouseReleased(event -> selectShapeOnMouseReleased(event.getX(), event.getY()));

        clearButton = new Button("Clear");
        clearButton.setOnAction(event -> clear());

        root.getChildren().addAll(radioButtonBox, graphicsPane, valueBox, clearButton);

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Graphic Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void selectShapeOnMousePressed(double x, double y) {

        if (lineButton.isSelected())
            drawLine(x, y);
        else if (rectangleButton.isSelected())
            drawRectangle(x, y);
        else if (circleButton.isSelected())
            drawCircle(x, y);
    }

    public void selectShapeOnMouseDragged(double x, double y) {

        if (lineButton.isSelected())
            changeLine(x, y);
        else if (rectangleButton.isSelected())
            changeRectangle(x, y);
        else if (circleButton.isSelected())
            changeCircle(x, y);
    }

    public void selectShapeOnMouseReleased(double x, double y) {

        if (lineButton.isSelected())
            releaseLine(x, y);
        else if (rectangleButton.isSelected())
            releaseRectangle(x, y);
        else if (circleButton.isSelected())
            releaseCircle(x, y);
    }


    // LINE
    public void drawLine(double x, double y) {

        line = new Line();
        line.setStartX(x);
        line.setStartY(y);
        line.setEndX(x);
        line.setEndY(y);
        line.setStrokeWidth(1);
        line.setStroke(Color.GREY);
        graphicsPane.getChildren().add(line);

    }

    private void changeLine(double x, double y) {

        line.setEndX(x);
        line.setEndY(y);
    }

    private void releaseLine(double x, double y) {

        line.setStroke(Color.BLACK);
    }


    // RECTANGLE
    public void drawRectangle(double x, double y) {

        rectangle = new Rectangle();
        rectangle.setLayoutX(x);
        rectangle.setLayoutY(y);
        rectangle.setWidth(0);
        rectangle.setHeight(0);
        rectangle.setStrokeWidth(1);
        rectangle.setStroke(Color.GREY);
        graphicsPane.getChildren().add(rectangle);

    }

    private void changeRectangle(double xMouse, double yMouse) {

        double LayoutX = rectangle.getX();
        double LayoutY = rectangle.getY();

        if ((xMouse > LayoutX) && (yMouse > LayoutY)) {

            rectangle.setWidth(xMouse-LayoutX);
            rectangle.setHeight(yMouse-LayoutY);

        } else if ((xMouse > LayoutX) && (yMouse < LayoutY)) {

            // TODO ... rectangle.setWidth(); correct scalings

            rectangle.setWidth(xMouse - rectangle.getX());
            rectangle.setHeight(rectangle.getY() - yMouse);

        } else if ((xMouse < LayoutX) && (yMouse < LayoutY)) {
            rectangle.setWidth(rectangle.getX() - xMouse);
            rectangle.setHeight(rectangle.getY() - yMouse);

        } else if ((xMouse < LayoutX) && (yMouse > LayoutY)) {
            rectangle.setWidth(rectangle.getX() - xMouse);
            rectangle.setHeight(yMouse - rectangle.getY());
        }
    }

    private void releaseRectangle(double x, double y) {

        rectangle.setStroke(Color.BLACK);
    }


    // CIRCLE
    public void drawCircle(double x, double y) {

        circle = new Circle();
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(0);
        circle.setStroke(Color.GREY);
        circle.setStrokeWidth(1);
        graphicsPane.getChildren().add(circle);

    }

    private void changeCircle(double x, double y) {

        double distance = Math.sqrt((Math.pow(x - circle.getCenterX(), x - circle.getCenterX())) + (Math.pow(y - circle.getCenterY(), y - circle.getCenterY())));
        circle.setRadius(distance);

    }

    private void releaseCircle(double x, double y) {

        circle.setStroke(Color.BLACK);
    }


    // CLEAR
    public void clear() {

        graphicsPane.getChildren().clear();
    }

    // MAIN ENTRY POINT

    public static void main(String[] args) {
        launch();
    }
}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleEllipse extends Application {

    private VBox root;
    private Pane graphicsPane;
    private GridPane gridPane;
    private Ellipse ellipse;
    private Rectangle rectangle;

    private Insets padding = new Insets(4);

    private boolean shapeState = true; // true is rectangle. false is ellipse.
    private boolean filled = false; // true is filled. false is empty.

    private double shapeHeight = 0.0;
    private double shapeWidth = 0.0;


    @Override
    public void start(Stage primaryStage) {

        // Layouts & Panes
        root = new VBox();
        graphicsPane = new Pane();
        gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(4);
        gridPane.setPadding(padding);

        // Initializing the graphicsPane
//        graphicsPane.setPrefSize(root.getWidth(), root.getHeight() - gridPane.getHeight());


        // Toggle and Radio Button Groups + Action Listeners
        ToggleGroup shapeGroup = new ToggleGroup();
        RadioButton radioRectangle = new RadioButton("Rechteck");
        radioRectangle.setOnAction(event -> makeRectangle());
        RadioButton radioEllipse = new RadioButton("Elipse");
        radioEllipse.setOnAction(event -> makeEllipse());
        shapeGroup.getToggles().addAll(radioRectangle, radioEllipse);

        ToggleGroup fillGroup = new ToggleGroup();
        RadioButton radioEmpty = new RadioButton("Leer");
        radioEmpty.setOnAction(event -> emptyShape());
        RadioButton radioFilled = new RadioButton("Gefüllt");
        radioFilled.setOnAction(event -> fillShape());
        fillGroup.getToggles().addAll(radioEmpty, radioFilled);

        // Adding the radioButtons to the gridPane
        gridPane.add(radioRectangle, 0, 0);
        gridPane.add(radioEllipse, 0, 1);
        gridPane.add(radioEmpty, 1, 0);
        gridPane.add(radioFilled, 1, 1);

        // Obligatories
        Scene scene = new Scene(root, 400, 200);
        scene.widthProperty().addListener((observable, oldValue, newValue) -> resizeShape());
        scene.heightProperty().addListener((observable, oldValue, newValue) -> resizeShape());

        // Initialize View
        radioRectangle.selectedProperty().setValue(true);
        radioEmpty.selectedProperty().setValue(true);

        // Add nodes
        root.getChildren().add(graphicsPane);
        root.getChildren().add(gridPane);

        primaryStage.setTitle("FOPT-Klausur im SS 2010");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void makeRectangle() {

        shapeState = true;

        calculateShapeSize();

        graphicsPane.getChildren().clear();
        rectangle = new Rectangle();
        rectangle.setLayoutX(4);
        rectangle.setLayoutY(4);
        rectangle.setWidth(shapeWidth);
        rectangle.setHeight(shapeHeight);
        if (filled)
            fillShape();
        else
            emptyShape();
        rectangle.setStroke(Color.BLACK);

        graphicsPane.getChildren().add(rectangle);
    }

    public void makeEllipse() {

        shapeState = false;
        calculateShapeSize();

        graphicsPane.getChildren().clear();
        ellipse = new Ellipse();
        ellipse.setLayoutX(4);
        ellipse.setLayoutY(4);
        ellipse.setRadiusX(shapeWidth / 2);
        ellipse.setRadiusY(shapeHeight / 2);
        ellipse.setCenterX(shapeWidth / 2);
        ellipse.setCenterY(shapeHeight / 2);
        if (filled)
            fillShape();
        else
            emptyShape();
        ellipse.setStroke(Color.BLACK);

        graphicsPane.getChildren().add(ellipse);
    }

    public void fillShape() {

        if (shapeState)
            rectangle.setFill(Color.BLACK);
        else
            ellipse.setFill(Color.BLACK);

        filled = true;
    }

    public void emptyShape() {

        if (shapeState)
            rectangle.setFill(null);
        else
            ellipse.setFill(null);

        filled = false;
    }

    public void resizeShape() {

        calculateShapeSize();

        if (shapeState) {
            rectangle.setWidth(shapeWidth);
            rectangle.setHeight(shapeHeight);
        } else {
            ellipse.setRadiusX(shapeWidth / 2);
            ellipse.setRadiusY(shapeHeight / 2);
            ellipse.setCenterX(shapeWidth / 2);
            ellipse.setCenterY(shapeHeight / 2);
        }
    }

    public void calculateShapeSize() {

        shapeHeight = root.getHeight() - gridPane.getHeight() - 8;
        shapeWidth = root.getWidth() - 8;
    }


    public static void main(String[] args) {
        launch();
    }
}

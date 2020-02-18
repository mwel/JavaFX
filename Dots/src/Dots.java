import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Dots extends Application {


    private int dotCounter = 0;
    private int dotColumn = 0;
    private int dotRow = 1;

    private int posX = 40;
    private int posY = 50;

    Group root;
    Pane dotsPane;
    HBox LabelBox;

    Label instructionLabel;
    Label errorLabel;

    Label dotCounterLabel;
    Label dotColumnLabel;
    Label dotRowLabel;

    Label dotCounterValueLabel;
    Label dotColumnValueLabel;
    Label rowCounterValueLabel;

    RadioButton radioButtonBlue;
    RadioButton radioButtonRed;
    RadioButton radioButtonGreen;
    RadioButton radioButtonBlack;

    ToggleGroup toggleGroup;

    Circle dot;


    @Override
    public void start(Stage primaryStage) {

        root = new Group();
        dotsPane = new Pane();
        dotsPane.setLayoutY(40);

        Insets padding = new Insets(10);

        instructionLabel = new Label("Make as many dots as you like . . .   ");
        instructionLabel.setLayoutX(20);
        instructionLabel.setLayoutY(20);

        errorLabel = new Label("");
        errorLabel.setLayoutX(200);
        errorLabel.setLayoutY(20);


        LabelBox = new HBox();
        LabelBox.setLayoutX(20);
        LabelBox.setLayoutY(40);

        dotCounterLabel = new Label("Dot Counter: ");
        dotCounterLabel.setPadding(padding);

        dotColumnLabel = new Label("Current Column");
        dotColumnLabel.setPadding(padding);

        dotRowLabel = new Label("Current Row");
        dotRowLabel.setPadding(padding);

        dotCounterValueLabel = new Label();
        dotCounterValueLabel.setPadding(padding);

        dotColumnValueLabel = new Label();
        dotColumnValueLabel.setPadding(padding);

        rowCounterValueLabel = new Label();
        rowCounterValueLabel.setPadding(padding);


        Button makeDotButton = new Button("Make a Dot");
        makeDotButton.setLayoutX(100);
        makeDotButton.setLayoutY(250);
        makeDotButton.setOnAction(e -> makeDot());

        Button eraseButton = new Button("Erase Dots");
        eraseButton.setLayoutX(300);
        eraseButton.setLayoutY(250);
        eraseButton.setOnAction(e -> erase());

        // Radio Buttons for color choice
        toggleGroup = new ToggleGroup();

        radioButtonBlue = new RadioButton("Blue");
        radioButtonBlue.setPadding(padding);
        radioButtonBlue.setSelected(true);
        radioButtonRed = new RadioButton("Red");
        radioButtonRed.setPadding(padding);
        radioButtonGreen = new RadioButton("Green");
        radioButtonGreen.setPadding(padding);
        radioButtonBlack = new RadioButton("Black");
        radioButtonBlack.setPadding(padding);

        toggleGroup.getToggles().addAll(radioButtonBlue, radioButtonRed, radioButtonGreen, radioButtonBlack);

        VBox radioButtonBox = new VBox();
        radioButtonBox.setPadding(padding);
        radioButtonBox.setLayoutX(500);
        radioButtonBox.setLayoutY(40);
        radioButtonBox.getChildren().addAll(radioButtonBlue, radioButtonRed, radioButtonGreen, radioButtonBlack);


        //Add nodes to panes and root

        LabelBox.getChildren().addAll(dotCounterLabel, dotCounterValueLabel, dotColumnLabel, dotColumnValueLabel, dotRowLabel, rowCounterValueLabel);

        root.getChildren().add(LabelBox);
        root.getChildren().add(instructionLabel);
        root.getChildren().add(errorLabel);
        root.getChildren().add(makeDotButton);
        root.getChildren().add(eraseButton);
        root.getChildren().add(radioButtonBox);
        root.getChildren().add(dotsPane);

        Scene scene = new Scene(root, 800, 300);

        primaryStage.setTitle("Dots");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void makeDot() {

        if (dotCounter < 30) {
            increaseCounter();
            increaseColumn();

            dot = new Circle();
            dot.setRadius(5);
            if (radioButtonBlack.selectedProperty().getValue()) {
                dot.setFill(Color.BLACK);
            } else if (radioButtonBlue.selectedProperty().getValue()) {
                dot.setFill(Color.BLUE);
            } else if (radioButtonRed.selectedProperty().getValue()) {
                dot.setFill(Color.RED);
            } else if (radioButtonGreen.selectedProperty().getValue()) {
                dot.setFill(Color.GREEN);
            }

            dot.setCenterX(posX * getDotColumn());
            dot.setCenterY(posY * getDotRow());

            dotsPane.getChildren().add(dot);

            System.out.println("Dot made #" + getDotCounter() + " | Column " + getDotColumn() + " | Row " + getDotRow());
            updateStats();

            rowHandler();
        } else {
            errorLabel.setText("Only 30 dots :D");
        }
    }


    private void erase() {

        resetDotCounter();
        resetDotColumn();
        resetDotRow();

        updateStats();

        dotsPane.getChildren().clear();
        errorLabel.setText("");

    }


    // dot Counter

    public int getDotCounter() {
        return dotCounter;
    }

    public void setDotCounter(int dotCounter) {
        this.dotCounter = dotCounter;
    }

    private void increaseCounter() {
        setDotCounter(getDotCounter() + 1);
    }

    public void resetDotCounter() {

        setDotCounter(0);
    }


    // dot Column
    public int getDotColumn() {
        return dotColumn;
    }

    public void resetDotColumn() {

        dotColumn = 0;
    }

    public void increaseColumn() {
        dotColumn++;
    }


    // dot Row

    public void increaseDotRow() {
        dotRow++;
    }

    public void resetDotRow() {

        dotRow = 1;
    }

    public void rowHandler() {
        if (dotColumn % 10 == 0) {
            increaseDotRow();
            resetDotColumn();
        }
    }

    public int getDotRow() {
        return dotRow;
    }

    public void setDotRow(int dotRow) {
        this.dotRow = dotRow;
    }


    // dot positions

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }


    public void updateStats() {
        dotCounterValueLabel.setText("" + getDotCounter());
        dotColumnValueLabel.setText("" + getDotColumn());
        rowCounterValueLabel.setText("" + getDotRow());
    }


    public static void main(String[] args) {
        launch();
    }
}

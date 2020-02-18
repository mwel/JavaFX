import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class BorderPaneTraining extends Application {

    Group root;
    GridPane gridPane;
    Label labelTop;
    Label labelBottom;
    Label labelLeft;
    Label labelRight;

    Button middleButton;


    private boolean buttonON = true;


    public void start(Stage primaryStage) {

        root = new Group();
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        final int numberOfColumns = 5;
        final int numberOfRows = 5;
        for (int i = 0; i < numberOfColumns; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / numberOfColumns);
            gridPane.getColumnConstraints().add(columnConstraints);
        }
        for (int i = 0; i < numberOfRows; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / numberOfRows);
            gridPane.getRowConstraints().add(rowConstraints);

        }

        gridPane.setPrefSize(500, 500);

        labelTop = new Label("TOP");
        labelBottom = new Label("BOTTOM");
        labelLeft = new Label("LEFT");
        labelRight = new Label("RIGHT");

        middleButton = new Button("ON");
        middleButton.setOnAction(event -> switchLabels());

        gridPane.add(labelTop, 2, 1);
        gridPane.add(labelBottom, 2, 3);
        gridPane.add(labelLeft, 1, 2);
        gridPane.add(labelRight, 3, 2);
        gridPane.add(middleButton, 2, 2);

        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("JavaFX Anwendung");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void switchLabels() {

        if (buttonON) {

            labelTop.setText("");
            labelBottom.setText("");
            labelLeft.setText("");
            labelRight.setText("");
            middleButton.setText("OFF");
            buttonON = false;

        } else {

            labelTop.setText("TOP");
            labelBottom.setText("BOTTOM");
            labelLeft.setText("LEFT");
            labelRight.setText("RIGHT");
            middleButton.setText("ON");
            buttonON = true;

        }

    }

    public static void main(String[] args) {

        launch();
    }
}
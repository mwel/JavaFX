import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    private int currentBricks = 0;
    private int checkSum = 0;

    private Group root;
    private Pane brickPane;
    private Slider slider;
    private Label label;
    private Rectangle brick;

    private final double brickWidth = 40.0;
    private final double brickHight = 20.0;

    private double brickPosX = 40.0;
    private double brickPosY = 20.0;

    private int brickColumn = 0;
    private int brickRow = 10;

    private int paneWidth = 600;
    private int paneHeight = 400;

    private int maxBricks = 300;
    private int onePercent = maxBricks / 100;


    @Override
    public void start(Stage primaryStage) {

        root = new Group();
        brickPane = new Pane();
        brickPane.setLayoutY(300);
        brickPane.setLayoutX(0);
        brickPane.setPrefSize(paneWidth, paneHeight);

        slider = new Slider(0, 100, 0); // Slider gibt % zurück.
        slider.setPrefWidth(600);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setPadding(new Insets(50, 50, 20, 50));

        slider.valueProperty().addListener((observable, oldValue, newValue) -> handleBricks(newValue.intValue()));

        label = new Label("0.0 %");
        label.setLayoutX(650);
        label.setLayoutY(20);

        Label header = new Label("Schaufenster");
        header.setPadding(new Insets(10));
        header.setLayoutX(370);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> label.setText(newValue + " %"));


        Button resetButton = new Button("Fenster reinigen");
        resetButton.setLayoutX(600);
        resetButton.setLayoutY(550);
        resetButton.setOnAction(event -> reset());

        root.getChildren().add(brickPane);
        root.getChildren().add(header);
        root.getChildren().add(resetButton);
        root.getChildren().add(label);
        root.getChildren().add(slider);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Bauklötze im Angebot");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void handleBricks(int newValue) {

        int targetAmount = newValue * onePercent; //targetAmount sind so viele Steine, wie im Fenster liegen sollen.

        if (targetAmount > currentBricks) {
            int addThisMany = targetAmount - currentBricks;
            for (int i = 0; i < addThisMany; i++) {
                Platform.runLater(this::putBrick);
                checkSum++;
            }
        } else if (targetAmount < currentBricks) {
            int takeThisMany = currentBricks - targetAmount;
            for (int i = 0; i < takeThisMany; i++) {
                Platform.runLater(this::removeBrick);
                checkSum--;
            }
        } else {
            return;
        }

        // Check whether the amount of bricks is correct.
        System.out.println("Brick Count at " + currentBricks);
        System.out.println("Check Sum   at " + checkSum);
    }

    public void putBrick() {


        brick = new Rectangle(brickWidth, brickHight);
        brick.setFill(Color.ROYALBLUE);
        brick.setStroke(Color.BLACK);

        brick.setLayoutX(brickPosX * brickColumn);
        brick.setLayoutY(brickPosY * brickRow);

        brickPane.getChildren().add(brick);
        currentBricks++;
        brickColumn++;
        if (currentBricks % 20 == 0) {
            brickRow--;
            brickColumn = 0;
        }
        System.out.println("Brick added.");
    }

    public void removeBrick() {

        int size = brickPane.getChildren().size();
        brickPane.getChildren().remove(size - 1);

        currentBricks--;
        brickColumn--;
        if (currentBricks % 20 == 0) {
            brickRow++;
            brickColumn = 0;
        }
        System.out.println("Brick removed.");

        if (currentBricks == 0) {
            reset();
        }

    }

    public void reset() {

        currentBricks = 0;
        brickColumn = 0;
        brickRow = 10;
        brickPosX = brickWidth;
        brickPosY = brickHight;

        slider.setValue(0.0);
        brickPane.getChildren().clear();

    }

    public static void main(String[] args) {
        launch();
    }
}

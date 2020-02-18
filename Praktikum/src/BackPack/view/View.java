package BackPack.view;

import BackPack.presenter.Presenter;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class View {

    private Presenter presenter;

    private VBox root = new VBox(10);
    private GridPane gridPane;

    private Label totalWeightValueLabel;

    public void init(List<String> names, List<Double> weights, double maxWeight) {

        Label totalWeightLabel = new Label("Total Weight");
        totalWeightValueLabel = new Label("");

        Label maxWeightLabel = new Label("Maximum Weight");
        Label maxWeightValueLabel = new Label("" + maxWeight);

        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(totalWeightLabel, 0, 0);
        gridPane.add(totalWeightValueLabel, 1, 0);
        gridPane.add(maxWeightLabel, 0, 1);
        gridPane.add(maxWeightValueLabel, 1, 1);


        root.getChildren().add(gridPane);

        for (int i = 0; i < names.size(); i++) {

            CheckBox checkBox = new CheckBox(names.get(i) + " (" + weights.get(i) + " kg)");
            root.getChildren().add(checkBox);
        }

    }

    public void updateTotalWeight(double total) {

        totalWeightValueLabel.setText("" + total);
    }

    public void updateEnabledItems(List<String> enabledItems) {



    }
}

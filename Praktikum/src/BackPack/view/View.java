package BackPack.view;

import BackPack.presenter.Presenter;
import javafx.scene.Node;
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

            String currentName = names.get(i);
            String checkBoxString = currentName + " (" + Double.toString((weights.get(i))) + ")";
            CheckBox checkBox = new CheckBox(checkBoxString);
            checkBox.setId(currentName);
            checkBox.selectedProperty().addListener(new CheckListener(presenter, currentName));
            root.getChildren().add(checkBox);
        }

    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    public void updateTotalWeight(double total) {

        totalWeightValueLabel.setText("Total Weight; " + Double.toString(total) + " kg");
    }

    public void updateEnabledItems(List<String> enabledItems) {

        for (Node n : root.getChildren()) {

            for (String string : enabledItems) {

                if (n.getId().equals(string)) {
                    n.setDisable(false);
                    break;
                }

            }


        }
    }
}
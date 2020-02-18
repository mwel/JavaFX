package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import presenter.Presenter;

public class View {

    private Presenter presenter;

    private GridPane pane;
    private Label question;
    private TextField solution;
    private Label status;

    public View(Presenter presenter) {
        this.presenter = presenter;
        initView();
    }

    private void initView() {
        pane = new GridPane();
        pane.setPadding(new Insets(6));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(new Label("Translate:"), 0, 0);

        question = new Label();
        pane.add(question, 0, 1);

        solution = new TextField();
        pane.add(solution, 1, 1);

        HBox buttons = new HBox(8);
        Button okay = new Button("Check");
        buttons.getChildren().add(okay);
        Button next = new Button("Continue");
        buttons.getChildren().add(next);
        pane.add(buttons, 0, 2, 2, 1);

        status = new Label();
        pane.add(status, 0, 3, 2, 1);

        EventHandler<ActionEvent> h = e -> presenter.check(question.getText(), solution.getText()); // Wie funktioniert das?
        solution.setOnAction(h);

        okay.setOnAction(h);

        next.setOnAction(e -> presenter.choose());
    }

    public Pane getUI() {
        return pane;
    }

    public void showNewWord(String word) {
        question.setText(word);
        solution.setText("");
    }

    public void eraseMessage() {
        status.setText("");
    }

    public void showOkayMessage() {
        status.setText("Correct! :D ");
    }

    public void showContinuationErrorMessage(int tries) {
        if (tries <= 1) {
            status.setText("Wrong. :/ " +
                    "Try again.");
        } else {
            status.setText("Wrong for the " + tries + ". time." + "Try again.");
        }
    }

    public void showFinalErrorMessage(int tries) {
        status.setText("Wrong for the " + tries + ". time." + "Next word...");
    }

    public void showNoInputMessage() {
        status.setText("No solution was entered.");
    }
}


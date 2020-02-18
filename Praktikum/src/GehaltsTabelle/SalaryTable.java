package GehaltsTabelle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SalaryTable extends Application {

    private VBox root;

    private TableView tableView;
    private TableColumn positionColumn;
    private TableColumn salaryColumn;

    private HBox buttonBox;

    private Button addButton;
    private Button changeButton;
    private Button deleteButton;
    private Button changeAllButton;

    private Insets padding = new Insets(20);

    private ObservableList<StringDoublePair> data;

    private List list;


    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new VBox(20);

        //Create the tabe, get the initial data and put in into the table.
        tableView = new TableView();
        data = getInitialData();
        tableView.setItems(data);

        positionColumn = new TableColumn("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        salaryColumn = new TableColumn("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tableView.getColumns().addAll(positionColumn, salaryColumn);


        // Buttons
        addButton = new Button("Add");
        addButton.setOnAction(event -> add());

        changeButton = new Button("Change");
        changeButton.setOnAction(event -> change());

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> delete());

        changeAllButton = new Button("Change All");
        changeAllButton.setOnAction(event -> changeAll());

        // HBox for buttons
        buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        buttonBox.setPadding(padding);
        buttonBox.getChildren().addAll(addButton, changeButton, deleteButton, changeAllButton);

        // FX Obligatories
        root.getChildren().add(tableView);
        root.getChildren().add(buttonBox);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Positions and Salaries");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private ObservableList<StringDoublePair> getInitialData() {

        list = new ArrayList<StringDoublePair>();

        list.add(new StringDoublePair("C-Level", 1000000));
        list.add(new StringDoublePair("Senior VP", 450000));
        list.add(new StringDoublePair("VP", 300000));
        list.add(new StringDoublePair("Senior Director", 250000));
        list.add(new StringDoublePair("Director", 200000));
        list.add(new StringDoublePair("Senior Manager", 175000));
        list.add(new StringDoublePair("Manager", 140000));
        list.add(new StringDoublePair("Senior Associate", 105000));
        list.add(new StringDoublePair("Associate", 85000));
        list.add(new StringDoublePair("Junior Associate", 45000));

        System.out.println("Initial list items: " + list.size());

        return FXCollections.observableList(list);
    }

    public void add() {

        Stage addDialogStage = new Stage();

        GridPane addDialogPane = new GridPane();
        addDialogPane.setPadding(padding);
        addDialogPane.setHgap(10);
        addDialogPane.setVgap(10);

        Label positionLabel = new Label("Position: ");
        Label salaryLabel = new Label("Salary: ");
        TextField positionTextField = new TextField();
        TextField salaryTextField = new TextField();

        Button addDialogButton = new Button("Add");
        addDialogButton.setOnAction(event -> {

            StringDoublePair nextPosition = new StringDoublePair(positionTextField.getText(), Double.parseDouble(salaryTextField.getText()));
            // list.add(nextPosition);
            System.out.println("Current items: " + list.size());
            tableView.getItems().add(nextPosition);// Hier wird das Element aber nur zum Table und nicht zur Liste hinzugefügt.
            addDialogStage.close();

        });

        Button cancelDialogButton = new Button("Cancel");
        cancelDialogButton.setOnAction(event -> addDialogStage.close());

        addDialogPane.add(positionLabel, 0, 0);
        addDialogPane.add(salaryLabel, 0, 1);
        addDialogPane.add(positionTextField, 1, 0);
        addDialogPane.add(salaryTextField, 1, 1);
        addDialogPane.add(addDialogButton, 0, 2);
        addDialogPane.add(cancelDialogButton, 1, 2);

        Scene addDialogScene = new Scene(addDialogPane);

        addDialogStage.setTitle("Add new position");
        addDialogStage.setScene(addDialogScene);
        addDialogStage.showAndWait();

    }

    public void change() {

        StringDoublePair selectedListItem = (StringDoublePair) tableView.getSelectionModel().getSelectedItem();

        Stage changeDialogStage = new Stage();

        GridPane changeDialogPane = new GridPane();
        changeDialogPane.setPadding(padding);
        changeDialogPane.setHgap(10);
        changeDialogPane.setVgap(10);

        Label positionLabel = new Label("Position: ");
        Label salaryLabel = new Label("Salary: ");
        TextField positionTextField = new TextField(selectedListItem.getPosition());
        TextField salaryTextField = new TextField(String.valueOf(selectedListItem.getSalary()));

        Button changeDialogButton = new Button("Change");
        changeDialogButton.setOnAction(event -> {

            selectedListItem.setPositionProp(positionLabel.getText());
            selectedListItem.setSalaryProp(Double.parseDouble(salaryTextField.getText()));

            changeDialogStage.close();

        });

        Button cancelDialogButton = new Button("Cancel");
        cancelDialogButton.setOnAction(event -> changeDialogStage.close());

        changeDialogPane.add(positionLabel, 0, 0);
        changeDialogPane.add(salaryLabel, 0, 1);
        changeDialogPane.add(positionTextField, 1, 0);
        changeDialogPane.add(salaryTextField, 1, 1);
        changeDialogPane.add(changeDialogButton, 0, 2);
        changeDialogPane.add(cancelDialogButton, 1, 2);

        Scene changeDialogScene = new Scene(changeDialogPane);

        changeDialogStage.setTitle("Add new position");
        changeDialogStage.setScene(changeDialogScene);
        changeDialogStage.showAndWait();

    }


    public void delete() {

        StringDoublePair selectedListItem = (StringDoublePair) tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedListItem);

    }

    public void changeAll() {

        Stage changeAllDialogStage = new Stage();

        GridPane changeDialogPane = new GridPane();
        changeDialogPane.setPadding(padding);
        changeDialogPane.setHgap(10);
        changeDialogPane.setVgap(10);

        Label changeValueLabel = new Label("Change Value: ");
        TextField changeValueTextField = new TextField();

        Button changeDialogButton = new Button("Change");
        changeDialogButton.setOnAction(event -> {
            changeAllSalaries(Double.parseDouble(changeValueTextField.getText()));
            changeAllDialogStage.close();
        });

        Button cancelDialogButton = new Button("Cancel");
        cancelDialogButton.setOnAction(event -> changeAllDialogStage.close());

        changeDialogPane.add(changeValueLabel, 0, 0);
        changeDialogPane.add(changeValueTextField, 1, 0);
        changeDialogPane.add(changeDialogButton, 0, 1);
        changeDialogPane.add(cancelDialogButton, 1, 1);

        Scene changeDialogScene = new Scene(changeDialogPane);

        changeAllDialogStage.setTitle("Change All Salaries");
        changeAllDialogStage.setScene(changeDialogScene);
        changeAllDialogStage.showAndWait();


    }

    public void changeAllSalaries(double changeValue) {

        for (int i = 0; i < tableView.getItems().size(); i++) {

            StringDoublePair currentItem = (StringDoublePair) tableView.getItems().get(i);
            double currentSalary = currentItem.getSalary();

            double newSalary = currentSalary * changeValue;

            currentItem.setSalaryProp(newSalary);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}

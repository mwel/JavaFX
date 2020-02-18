package presenter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import sample.GroupTree;
import view.View;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Presenter p = new Presenter();
        View v = new View(p);
        Model m = new Model();
        p.setModelAndView(m, v);
        p.choose(); //automatic launch of first vocab
        Scene scene = new Scene(v.getUI());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vokabel-Training");
        primaryStage.show();

        System.out.println("start: thread = " + Thread.currentThread().getName());
        GroupTree.dumpAll();
    }


    public static void main(String[] args) {
        launch(args);

    }
}

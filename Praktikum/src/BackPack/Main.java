package BackPack;

import BackPack.model.Model;
import BackPack.presenter.Presenter;
import BackPack.view.View;

public class Main {

    public static void main(String[] args) {

        String[] names = new String[]{"Apfel", "Birne", "Pocket Knife", "Beer", "Bottle Opener", "Sleeping Bag", "Food Package"};
        double[] weights = new double[]{0.02, 0.019, 0.015, 0.6, 0.001, 2.5, 4.0};
        double maxWeight = 5.0;

        Model model = new Model(names, weights, maxWeight);
        View view = new View();
        Presenter presenter = new Presenter(model, view);

    }
}

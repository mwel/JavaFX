package BackPack.presenter;

import BackPack.model.Model;
import BackPack.view.View;

public class Presenter {

    private Model model;
    private View view;

    public Presenter(Model model, View view) {

        this.model = model;
        this.view = view;
    }

    public void newCheck(String name, Boolean selected) {
        model.setSelected(name, selected);
        view.updateTotalWeight(model.getSumofUsedWeights());
        view.updateEnabledItems(model.getEnabledItems());
    }

public void initView() {

        view.init(model.getAllItemNames(), model.getAllItemWeights(), model.getMaxWeight());
}
}

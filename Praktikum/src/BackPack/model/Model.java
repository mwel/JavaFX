package BackPack.model;

import java.util.LinkedList;
import java.util.List;

public class Model {

    private String[] names;
    private double maxWeight;
    private double[] weights;
    private List<Item> itemList;

    public Model(String[] names, double[] weights, double maxWeight) {

        for (int i = 0; i < weights.length; i++) {
            if ((weights[i] > maxWeight) || !(names.length == weights.length)) throw new IllegalArgumentException();

            itemList.add(new Item(names[i], weights[i], false));
        }

        this.names = names;
        this.weights = weights;
        this.maxWeight = maxWeight;
    }

    public double getSumofUsedWeights() {

        double sumOfUsedWeights = 0;
        for (double weight : weights)
            sumOfUsedWeights += weight;

        return sumOfUsedWeights;
    }

    public List<String> getAllItemNames() {

        List<String> itemList = null;
        for (String name : names)
            itemList.add(name);
        return itemList;
    }

    public List<Double> getAllItemWeights() {

        List<Double> itemWeightList = null;
        for (double weight : weights)
            itemWeightList.add(weight);
        return itemWeightList;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public List<String> getEnabledItems() {

        List<String> selectableList = new LinkedList<>();
        for (Item item : itemList) {
            if (!item.isSelected() && ((getSumofUsedWeights() + item.getWeight()) <= getMaxWeight())) {
                selectableList.add(item.getName());
            }
        }
        return selectableList;
    }
}

package BackPack.model;

public class Item {

    private final double weight;
    private boolean selected;
    private final String name;

    public Item(String name, double weight, boolean selected) {
        this.weight = weight;
        this.selected = selected;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }
}

package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

class SimpleChangeListener implements ChangeListener<Number> {

    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

        System.out.println("Number changed: " + oldValue + " >> " + newValue);

    }
}

public class PropertiesWithListeners {

    public static void main(String[] args) {

        SimpleIntegerProperty property = new SimpleIntegerProperty();
        SimpleChangeListener listener = new SimpleChangeListener();
        property.addListener(listener);
        for (int i = 1; i <= 20; i++) {

            int newValue = (int) (Math.random() * 10) - 5;
            System.out.println("Change: " + newValue);
            property.set(newValue);

        }
    }
}

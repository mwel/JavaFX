package GehaltsTabelle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class StringDoublePair {

    private SimpleStringProperty positionProp = new SimpleStringProperty();
    private SimpleDoubleProperty salaryProp = new SimpleDoubleProperty();

    public StringDoublePair(String position, double salary) {

        setPositionProp(position);
        setSalaryProp(salary);
    }


    //positionProp
    public void setPositionProp(String newPosition) {

        positionProp.set(newPosition);
    }

    public final String getPosition() {

        return positionProp.get();
    }

    public SimpleStringProperty positionProperty() {

        return positionProp;
    }


    // salaryProp
    public void setSalaryProp(double newSalary) {

        salaryProp.set(newSalary);
    }

    public double getSalary() {

        return salaryProp.get();
    }

    public SimpleDoubleProperty salaryProperty() {

        return salaryProp;
    }
}

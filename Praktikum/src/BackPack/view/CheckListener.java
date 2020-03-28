package BackPack.view;

import BackPack.presenter.Presenter;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CheckListener implements ChangeListener<? super Boolean>, InvalidationListener {
    public CheckListener(Presenter presenter, String currentName) {
    }

    @Override
    public void invalidated(Observable observable) {

    }

    @Override
    public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {

    }
}

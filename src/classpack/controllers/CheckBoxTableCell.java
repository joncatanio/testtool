package classpack.controllers;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.*;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.BooleanProperty;

/**
 * Created by alexg on 11/29/15.
 */

//CheckBoxTableCell for creating a CheckBox in a table cell
public static class CheckBoxTableCell<S, T> extends TableCell<S, T> {
    private final CheckBox checkBox;
    private ObservableValue<T> ov;

    public CheckBoxTableCell() {
        this.checkBox = new CheckBox();
        setGraphic(checkBox);
    }

    @Override public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setGraphic(checkBox);
            if (ov instanceof BooleanProperty) {
                checkBox.selectedProperty().unbindBidirectional((BooleanProperty) ov);
            }
            ov = getTableColumn().getCellObservableValue(getIndex());
            if (ov instanceof BooleanProperty) {
                checkBox.selectedProperty().bindBidirectional((BooleanProperty) ov);
            }
        }
    }
}
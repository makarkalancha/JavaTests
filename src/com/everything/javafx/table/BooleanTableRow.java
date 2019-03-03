package com.everything.javafx.table;

/**
 * User: Makar Kalancha
 * Date: 28/12/2017
 * Time: 19:31
 */

import com.google.common.base.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class BooleanTableRow<T> {
    private final T item;
    private boolean isChecked;

    public BooleanTableRow(T item, boolean isChecked) {
        this.item = item;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public T getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof BooleanTableRow){
            BooleanTableRow that = (BooleanTableRow) o;
            return Objects.equal(item, that.item)
                    && Objects.equal(isChecked, that.isChecked);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(item, isChecked);
    }

    public static <I> ObservableList<BooleanTableRow<I>> convertListIntoBooleanTableRowList(List<I> items, boolean isChecked){
        return FXCollections.observableArrayList(
                items.stream()
                        .map(item -> new BooleanTableRow<I>(item, isChecked))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return "BooleanTableRow{" +
                "item=" + item +
                ", isChecked=" + isChecked +
                '}';
    }
}
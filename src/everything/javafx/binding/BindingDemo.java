package everything.javafx.binding;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 17/04/2016
 * Time: 18:04
 */
public class BindingDemo {
    public static void main(String[] args) {
        Main main = new Main();
        main.loadPage();
    }

    public static class Main{
        private CareTaker ct = new CareTaker();
        private IntegerProperty size = new SimpleIntegerProperty();
        private BooleanProperty isEmpty = new SimpleBooleanProperty();

        public void loadPage(){
            Fm fm = new Fm();
            Toolbar tb = new Toolbar();

            fm.setParent(this);
            tb.setParent(this);
            log();
            System.out.println("1========================");
            fm.refresh();
            System.out.println("2========================");
            fm.refresh();
            System.out.println("3========================");
            fm.refresh();
            System.out.println("4========================");
            fm.refresh();
        }

        private void log(){
            System.out.println("Main->loadPage.size:"+size.getValue());
            System.out.println("Main->loadPage.isEmpty:"+isEmpty.getValue());
        }

        public CareTaker getCareTaker() {
            return ct;
        }

        public IntegerProperty sizeProperty() {
            return size;
        }

        public BooleanProperty isEmptyProperty() {
            return isEmpty;
        }
    }

    public static class Fm implements ControlledScreen{
        private CareTaker ct;
        private IntegerProperty size = new SimpleIntegerProperty();
        private BooleanProperty isEmpty = new SimpleBooleanProperty(true);
        @Override
        public void setParent(Main main) {
            ct = main.getCareTaker();
            main.size.bind(size);
            main.isEmpty.bind(isEmpty);
            log("setParent");
        }

        public void refresh(){
            ct.addToList(1);
            ct.addToList(2);
            ct.addToList(3);
            size.set(ct.getListSize());
            isEmpty.set(ct.isEmpty());
            log("refresh");
        }

        public void log(String method){
            System.out.println("Fm->" + method + ".size:" + size.getValue());
            System.out.println("Fm->" + method + ".isEmpty:"+isEmpty.getValue());
        }
    }

    public static class Toolbar implements ControlledScreen{
        private CareTaker ct;
        private IntegerProperty size = new SimpleIntegerProperty();
        private BooleanProperty isEmpty = new SimpleBooleanProperty();
        @Override
        public void setParent(Main main) {
            ct = main.getCareTaker();
            size.bind(main.size);
            isEmpty.bind(main.isEmpty);
            log("setParent");

            size.addListener((observable, oldValue, newValue) -> {
                log("size.addListener");
            });

            isEmpty.addListener((observable, oldValue, newValue) -> {
                log("isEmpty.addListener");
            });
        }

        public void log(String method){
            System.out.println("Toolbar->" + method + ".size:" + size.getValue());
            System.out.println("Toolbar->" + method + ".isEmpty:"+isEmpty.getValue());
        }
    }

    public static class CareTaker{
        List<Integer> list = new ArrayList<>();

        public boolean addToList(int i){
            return list.add(i);
        }

        public Integer remove(int index){
            return list.remove(index);
        }

        public int getListSize(){
            return list.size();
        }

        public boolean isEmpty(){
            return list.isEmpty();
        }
    }

    public interface ControlledScreen{
        void setParent(Main main);
    }


}

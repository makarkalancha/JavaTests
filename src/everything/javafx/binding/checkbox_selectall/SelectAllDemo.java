package everything.javafx.binding.checkbox_selectall;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Makar Kalancha
 * Date: 27 Feb 2017
 * Time: 09:28
 */
public class SelectAllDemo extends Application{
    private ObservableSet<String> selectedNames = FXCollections.observableSet();
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 250);

        CheckBox selectAll  = new CheckBox("all");
        selectAll.setAllowIndeterminate(true);
        selectAll.setIndeterminate(true);

        Separator separator = new Separator();
        CheckBox cb1= new CheckBox("cb1");
        cb1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                selectedNames.add(cb1.getText());
            }else {
                selectedNames.remove(cb1.getText());
            }
        });
        CheckBox cb2= new CheckBox("cb2");
        cb2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                selectedNames.add(cb2.getText());
            }else {
                selectedNames.remove(cb2.getText());
            }
        });
        CheckBox cb3= new CheckBox("cb3");
        cb3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                selectedNames.add(cb3.getText());
            }else {
                selectedNames.remove(cb3.getText());
            }
        });

        selectAll.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                cb1.setSelected(true);
                cb2.setSelected(true);
                cb3.setSelected(true);
            }else {
                cb1.setSelected(false);
                cb2.setSelected(false);
                cb3.setSelected(false);
            }
        });
        IntegerProperty checkboxQty = new SimpleIntegerProperty(4);
        BooleanBinding booleanBinding = checkboxQty.isEqualTo(Bindings.size(selectedNames));
        booleanBinding.addListener((observable, oldValue, newValue) -> {
            if(newValue){
                selectAll.setSelected(true);
            }else {
                selectAll.setSelected(false);
            }
        });

        root.getChildren().addAll(selectAll, separator, cb1, cb2, cb3);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

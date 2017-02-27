package everything.javafx.binding.checkbox_selectall;

import javafx.application.Application;
import javafx.application.Platform;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 27 Feb 2017
 * Time: 09:28
 */
public class SelectAllDemo extends Application{
    private ObservableSet<String> selectedNames = FXCollections.observableSet();
    private CheckBox selectAll = new CheckBox("all");
    private List<CheckBox> checkBoxList  = new ArrayList<>();
    private Runnable selectAllStateChangeProcessor;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 250);

        //https://coderanch.com/t/667118/java/Indeterminate-Select-CheckBox

        Separator separator = new Separator();
        CheckBox cb1= new CheckBox("cb1");
        cb1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            selectCheckBox();
        });
        CheckBox cb2= new CheckBox("cb2");
        cb2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            selectCheckBox();
        });
        CheckBox cb3= new CheckBox("cb3");
        cb3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            selectCheckBox();
        });

        checkBoxList.addAll(Arrays.asList(cb1, cb2, cb3));

//        selectAll.setAllowIndeterminate(true);
        selectAll.setAllowIndeterminate(false);
        selectAll.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scheduleSelectAllStateChangeProcessing();
        });
        selectAll.indeterminateProperty().addListener((observable, oldValue, newValue) -> {
            scheduleSelectAllStateChangeProcessing();
        });

//        IntegerProperty checkboxQty = new SimpleIntegerProperty(4);
//        BooleanBinding booleanBinding = checkboxQty.isEqualTo(Bindings.size(selectedNames));
//        booleanBinding.addListener((observable, oldValue, newValue) -> {
//            if(newValue){
//                selectAll.setSelected(true);
//            }else {
//                selectAll.setSelected(false);
//            }
//        });

        root.getChildren().addAll(selectAll, separator, cb1, cb2, cb3);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    private boolean isAllSelected(){
//        return selectedNames.size() == 4;
//    }

    private void selectCheckBox(){
        if(selectAllStateChangeProcessor == null) {
            boolean allSelected = checkBoxList.stream()
                    .map(CheckBox::isSelected)
                    .reduce(true, (a, b) -> a && b);
            boolean anySelected = checkBoxList.stream()
                    .map(CheckBox::isSelected)
                    .reduce(false, (a, b) -> a || b);

            if(allSelected){
                selectAll.setSelected(true);
                selectAll.setIndeterminate(false);
            }

            if(!anySelected){
                selectAll.setSelected(false);
                selectAll.setIndeterminate(false);
            }

            if(anySelected && !allSelected){
                selectAll.setSelected(false);
                selectAll.setIndeterminate(true);
            }
        }
    }

    private void scheduleSelectAllStateChangeProcessing(){
        if(selectAllStateChangeProcessor == null){
            selectAllStateChangeProcessor = this::processSelectAllStateChange;
            Platform.runLater(selectAllStateChangeProcessor);
        }
    }

    private void processSelectAllStateChange(){
        if(!selectAll.isIndeterminate()){
            checkBoxList.forEach(checkBox -> checkBox.setSelected(selectAll.isSelected()));
        }
        selectAllStateChangeProcessor = null;
    }
}

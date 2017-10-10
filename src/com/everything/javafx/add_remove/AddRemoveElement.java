package com.everything.javafx.add_remove;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 01 Aug 2017
 * Time: 17:58
 */
public class AddRemoveElement extends Application{
    private static final String RESOURCE_PATH = "com/everything/javafx/add_remove/";
    private VBox leftVB;
    private TreeItem<String> rootLeaf;
    private VBox rightVB;
    private VBox currencyAddedRightVB;
    private HBox addElementHB;
    private TextField currencyMultiplicatorTF;
    private Button currencyAddElementBtn;
    private ComboBox<String> currencyACCB;
    private Multimap<String, String> addedCurrency = TreeMultimap.create();
    private Button currencyAddBtn;
    private ScrollPane rightSP;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeAddElementHB();

//        leftVB = new VBox(5);
//        setLeft();
        rootLeaf = new TreeItem<>("root");
        rootLeaf.setExpanded(true);

        TreeView<String> leftTrV = new TreeView<>(rootLeaf);
        leftTrV.setShowRoot(false);
        leftTrV.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> item = (TreeItem<String>) newValue;
            if(item.isLeaf()){
                TreeItem<String> root = item.getParent();
                populateTreeView(root);
            } else {
                populateTreeView(item);
            }

        });

//        leftVB.getChildren().add(leftTrV);

        rightVB = new VBox(5);
        setRight();

        rightSP = new ScrollPane();
        rightSP.setContent(rightVB);
        rightSP.vvalueProperty().bind(rightVB.heightProperty());

        currencyAddBtn = new Button("Add");
        VBox rightMainVB = new VBox();
        rightMainVB.getChildren().addAll(rightSP, currencyAddBtn);

        HBox mainHB = new HBox(5);
        mainHB.getChildren().addAll(leftTrV,rightMainVB);

        initializeControls();

        Scene scene = new Scene(mainHB, 450, 100);
        primaryStage.setTitle("add remove");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setRight(){
        ObservableList<String> currencyList= FXCollections.observableArrayList("curr 1", "curr 2", "curr 3");
        currencyACCB = new ComboBox<>(currencyList);
        currencyAddedRightVB = new VBox(5);

//        rightVB.setPrefHeight(150d);
        rightVB.getChildren().addAll(currencyACCB, currencyAddedRightVB, addElementHB);
    }

    private void initializeAddElementHB(){
        addElementHB = new HBox(5);
        currencyMultiplicatorTF = new TextField();
        currencyAddElementBtn = new Button();
        currencyAddElementBtn.setGraphic(new ImageView(RESOURCE_PATH + "plus-297823_1280_v1_16_16.png"));

        addElementHB.getChildren().addAll(currencyMultiplicatorTF, currencyAddElementBtn);
        currencyMultiplicatorTF.setDisable(true);
        currencyAddElementBtn.setDisable(true);
    }

    private void initializeControls(){
        currencyACCB.valueProperty().addListener((observable, oldValue, newValue) -> {
            currencyMultiplicatorTF.setDisable(StringUtils.isBlank(newValue));
        });

        currencyMultiplicatorTF.textProperty().addListener((observable, oldValue, newValue) -> {
            currencyAddElementBtn.setDisable(StringUtils.isBlank(newValue));
        });

        currencyAddElementBtn.setOnAction(event -> {
            String text = currencyMultiplicatorTF.getText();
            currencyMultiplicatorTF.setText("");

            setAddedCurrencyElements(text);

        });

        currencyAddBtn.setOnAction(event -> {
            String key = currencyACCB.getValue();

            addedCurrency.removeAll(key);
            rootLeaf.getChildren().clear();


            System.out.println(key);
//            List<String> list = rightVB.getChildren().stream()
//                    .filter(node -> node instanceof HBox)
//                    .filter(node -> ((HBox)node).getChildren().get(0) instanceof Label)
//                    .map(hbox -> ((Label)((HBox)hbox).getChildren().get(0)).getText())
//                    .collect(Collectors.toList());
            List<String> list = currencyAddedRightVB.getChildren().stream()
                    .filter(node -> node instanceof HBox)
                    .filter(node -> ((HBox) node).getChildren().get(0) instanceof Label)
                    .map(node -> ((Label) ((HBox) node).getChildren().get(0)).getText())
                    .collect(Collectors.toList());
            System.out.println(list);
            addedCurrency.putAll(key,
                    list
            );
            System.out.println(addedCurrency);

            for(String multimapKey : addedCurrency.keySet()){
//                for(Collection<String> values : addedCurrency.get(multimapKey)) {
                Collection<String> values = addedCurrency.get(multimapKey);
                TreeItem<String> keyTreeItem = new TreeItem<String>(multimapKey);
                keyTreeItem.setExpanded(true);

                for(String value : values) {
                    TreeItem<String> valueTreeItem = new TreeItem<String>(value);
                    keyTreeItem.getChildren().add(valueTreeItem);
                }

                rootLeaf.getChildren().add(keyTreeItem);
            }

            currencyAddedRightVB.getChildren().clear();
            currencyACCB.setValue("");
        });
    }

    private void setAddedCurrencyElements(String text){
        int hBoxIndex = rightVB.getChildren().size() - 1;//remove

        Label label = new Label(text);
        Button removeBtn = new Button();
        removeBtn.setGraphic(new ImageView(RESOURCE_PATH + "1473728052_button-remove_red_16x16.png"));
        removeBtn.setOnAction(event1 -> {
            Button btn = (Button)event1.getSource();
            HBox parentHB = (HBox)btn.getParent();
            System.out.println(parentHB.getId());//remove

//                addedCurrency.remove(currencyACCB.getValue(), ((Label)parentHB.getChildren().get(0)).getText());

//                rightVB.getChildren().remove(parentHB);
            currencyAddedRightVB.getChildren().remove(parentHB);
        });
        HBox labelRemoveBtn = new HBox(5);
        labelRemoveBtn.setId(Integer.toString(hBoxIndex));//remove
        labelRemoveBtn.getChildren().addAll(label, removeBtn);

//            addedCurrency.put(currencyACCB.getValue(), text);

//            rightVB.getChildren().add(hBoxIndex, labelRemoveBtn);
        currencyAddedRightVB.getChildren().add(labelRemoveBtn);
    }

    private void populateTreeView(TreeItem<String> item){
        currencyACCB.setValue(item.getValue());
        Collection<String> strings = addedCurrency.get(item.getValue());
        for(String string : strings) {
            setAddedCurrencyElements(string);
        }
    }
}

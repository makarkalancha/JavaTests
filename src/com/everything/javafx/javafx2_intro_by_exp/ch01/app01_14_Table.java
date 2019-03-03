package com.everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_14_Table extends Application {

    public static class Person{
        private StringProperty aliasName;
        private StringProperty firstName;
        private StringProperty lastName;
        private ObservableList<Person> employees = FXCollections.observableArrayList();

        public Person(String aliasName, String firstName, String lastName) {
            setAliasName(aliasName);
            setFirstName(firstName);
            setLastName(lastName);
        }

        /////////////////////////////////

        public StringProperty aliasNameProperty(){
            if(aliasName == null) {
                aliasName = new SimpleStringProperty();
            }
            return aliasName;
        }

        public String getAliasName() {
            return aliasNameProperty().get();
        }

        public void setAliasName(String value) {
            aliasNameProperty().set(value);
        }

        /////////////////////////////////

        public ObservableList<Person> employeesProperty() {
            return employees;
        }

        /////////////////////////////////

        public StringProperty firstNameProperty(){
            if(firstName == null) {
                firstName = new SimpleStringProperty();
            }
            return firstName;
        }

        public String getFirstName() {
            return firstNameProperty().get();
        }

        public void setFirstName(String firstName) {
            firstNameProperty().set(firstName);
        }

        /////////////////////////////////

        public StringProperty lastNameProperty(){
            if(lastName == null) {
                lastName = new SimpleStringProperty();
            }
            return lastName;
        }

        public String getLastName() {
            return lastNameProperty().get();
        }

        public void setLastName(String lastName) {
            lastNameProperty().set(lastName);
        }
    }

    private ObservableList<Person> getPeople() {
        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
        Person docX = new Person("Professor X", "Charles", "Xavier");
        docX.employeesProperty().add(new Person("Wolverine", "James", "Howlett"));
        docX.employeesProperty().add(new Person("Cyclops", "Scott", "Summers"));
        docX.employeesProperty().add(new Person("Storm", "Ororo", "Munroe"));

        Person magneto = new Person("Magneto", "Max", "Eisenhardt");
        magneto.employeesProperty().add(new Person("Juggernaut", "Cain", "Marko"));
        magneto.employeesProperty().add(new Person("Mystique", "Raven", "Darkhölme"));
        magneto.employeesProperty().add(new Person("Sabretooth", "Victor", "Creed"));

        Person biker = new Person("Mountain Biker", "Jonathan", "Gennick");
        biker.employeesProperty().add(new Person("Josh", "Joshua", "Juneau"));
        biker.employeesProperty().add(new Person("Freddy", "Freddy", "Guime"));
        biker.employeesProperty().add(new Person("Mark", "Mark", "Beaty"));
        biker.employeesProperty().add(new Person("John", "John", "O'Conner"));
        biker.employeesProperty().add(new Person("D-Man", "Carl", "Dea"));

        people.add(docX);
        people.add(magneto);
        people.add(biker);

        return people;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 1-14 Table");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 250, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //candidates label
        Label candidatesLbl = new Label("Boss");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridPane.add(candidatesLbl, 0, 0);

        //list of leaders
        ObservableList<Person> leaders = getPeople();
        final ListView<Person> leaderListView = new ListView<>(leaders);
        leaderListView.setPrefWidth(150);
        leaderListView.setPrefHeight(150);

        //display first and last name with tooktip using alias
        leaderListView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                final Label leadLbl = new Label();
                final Tooltip tooltip = new Tooltip();
                final ListCell<Person> cell = new ListCell<Person>() {
                    @Override
                    protected void updateItem(Person item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            leadLbl.setText(item.getAliasName());
                            setText(item.getFirstName() + " " + item.getLastName());
                            tooltip.setText(item.getAliasName());
                            setTooltip(tooltip);
                        }
                    }
                };//List cell
                return cell;
            }
        });//setCellFactory

        gridPane.add(leaderListView, 0, 1);

        Label emplLbl = new Label("Employees");
        gridPane.add(emplLbl, 2, 0);
        GridPane.setHalignment(emplLbl, HPos.CENTER);

        final TableView<Person> employeeTableView = new TableView<>();
        employeeTableView.setPrefWidth(300);
        final ObservableList<Person> teamMembers = FXCollections.observableArrayList();
        employeeTableView.setItems(teamMembers);

        TableColumn<Person, String> aliasNameCol = new TableColumn<>("Alias");
        aliasNameCol.setEditable(true);
        aliasNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("aliasName"));
        aliasNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setEditable(true);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setEditable(true);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setPrefWidth(employeeTableView.getPrefWidth() / 3);

        employeeTableView.getColumns().setAll(aliasNameCol, firstNameCol, lastNameCol);
        gridPane.add(employeeTableView, 2, 1);

        //selection listening
        leaderListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
            @Override
            public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                if (observable != null && observable.getValue() != null) {
                    teamMembers.clear();
                    teamMembers.addAll(observable.getValue().employeesProperty());
                }
            }
        });

        root.getChildren().add(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}

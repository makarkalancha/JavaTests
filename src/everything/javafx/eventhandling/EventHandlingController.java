package everything.javafx.eventhandling;

import everything.javafx.eventhandling.memento.per_form.FormState;
import everything.javafx.eventhandling.memento.per_form.UndoFormCakeTaker;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

/**
 * View-Controller for the person table.
 * 
 * @author Marco Jakob
 */
public class EventHandlingController{

	private UndoFormCakeTaker cakeTaker = new UndoFormCakeTaker();
    private SimpleBooleanProperty isNotUndo = new SimpleBooleanProperty(true);

    private SimpleStringProperty myTextFieldProperty = new SimpleStringProperty();
    private SimpleBooleanProperty myCheckBoxProperty = new SimpleBooleanProperty();
//    private Map<String, Property> mapProperty = new HashMap<>();
//    private static final String TF_KEY = "myTextFieldProperty";
//    private static final String CB_KEY = "myCheckBoxProperty";

    @FXML
    private Button undoButton;

    @FXML
    private Button redoButton;

	@FXML
	private Button myButton;
	
	@FXML
	private CheckBox myCheckBox;
	
	@FXML
	private ComboBox<Person> myComboBox;
	private ObservableList<Person> myComboBoxData = FXCollections.observableArrayList();
	
	@FXML
	private Hyperlink myHyperlink;
	
	@FXML
	private Slider mySlider;
	
	@FXML
	private TextField myTextField;
	
	@FXML
	private ListView<Person> myListView;
	private ObservableList<Person> listViewData = FXCollections.observableArrayList();
	
	@FXML
	private TextArea outputTextArea;


	
	/**
	 * The constructor (is called before the initialize()-method).
	 */
	public EventHandlingController() {
//        formSnapshot = new FormSnapshot(myTextFieldProperty, myCheckBoxProperty);
//
//        mapProperty.put(TF_KEY, myTextFieldProperty);
//        mapProperty.put(CB_KEY, myCheckBoxProperty);

        // Create some sample data for the ComboBox and ListView.
        myComboBoxData.add(new Person("Hans", "Muster"));
        myComboBoxData.add(new Person("Ruth", "Mueller"));
        myComboBoxData.add(new Person("Heinz", "Kurz"));
        myComboBoxData.add(new Person("Cornelia", "Meier"));
        myComboBoxData.add(new Person("Werner", "Meyer"));

        listViewData.add(new Person("Lydia", "Kunz"));
        listViewData.add(new Person("Anna", "Best"));
        listViewData.add(new Person("Stefan", "Meier"));
        listViewData.add(new Person("Martin", "Mueller"));
    }

    /**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
        myCheckBox.selectedProperty().bindBidirectional(myCheckBoxProperty);
        myTextField.textProperty().bindBidirectional(myTextFieldProperty);

        // Handle Button event.
        myButton.setOnAction((event) -> {
            outputTextArea.appendText("Button Action\n");
        });

        // Handle CheckBox event.

        myCheckBox.setOnAction((event) -> {
            boolean selected = myCheckBox.isSelected();
            outputTextArea.appendText("CheckBox Action (selected: " + selected + ")\n");
//            cakeTaker.saveState(new BooleanStateMemento(CB_KEY, !selected));
            cakeTaker.saveState(saveFormState());
        });

        // Init ComboBox items.
		myComboBox.setItems(myComboBoxData);
		
		// Define rendering of the list of values in ComboBox drop down. 
        myComboBox.setCellFactory((comboBox) -> {
            return new ListCell<Person>() {
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getFirstName() + " " + item.getLastName());
                    }
                }
            };
        });
		
		// Define rendering of selected value shown in ComboBox.
        myComboBox.setConverter(new StringConverter<Person>() {
            @Override
            public String toString(Person person) {
                if (person == null) {
                    return null;
                } else {
                    return person.getFirstName() + " " + person.getLastName();
                }
            }

            @Override
            public Person fromString(String personString) {
                return null; // No conversion fromString needed.
            }
        });

        // Handle ComboBox event.
        myComboBox.setOnAction((event) -> {
            Person selectedPerson = myComboBox.getSelectionModel().getSelectedItem();
            outputTextArea.appendText("ComboBox Action (selected: " + selectedPerson.toString() + ")\n");
        });

        // Handle Hyperlink event.
        myHyperlink.setOnAction((event) -> {
            outputTextArea.appendText("Hyperlink Action\n");
        });
		
		// Init ListView.
        myListView.setItems(listViewData);
        myListView.setCellFactory((list) -> {
            return new ListCell<Person>() {
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getFirstName() + " " + item.getLastName());
                    }
                }
            };
        });
		
		// Handle ListView selection changes.
		myListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("ListView Selection Changed (selected: " + newValue.toString() + ")\n");
        });

        // Handle Slider value change events.
        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            outputTextArea.appendText("Slider Value Changed (newValue: " + newValue.intValue() + ")\n");
        });
		
		// Handle TextField text changes.

//        myTextField.textProperty().bind(myTextFieldProperty);
        myTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//        myTextFieldProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println(
                    "EventHandlingController.myTextField.textProperty().addListener->cakeTaker.saveState:" + myTextFieldProperty.getValue());
            if (isNotUndo.getValue()/* && isNotRedo.getValue()*/) {
//                cakeTaker.saveState(new StringStateMemento(TF_KEY, newValue));
                cakeTaker.saveState(saveFormState());
            } else {
                isNotUndo.setValue(true);
//                isNotRedo.setValue(true);
            }
            System.out.println(
                    "EventHandlingController.myTextField.textProperty().addListener->myTextFieldProperty:" + myTextFieldProperty.getValue());
//            cakeTaker.saveState(new StringStateMemento(myTextFieldProperty));
            outputTextArea.appendText("TextField Text Changed (newValue: " + newValue + ")\n");
        });

        // Handle TextField enter key event.
		myTextField.setOnAction((event) -> {
            outputTextArea.appendText("TextField Action\n");
        });

        //        https://docs.oracle.com/javase/8/javafx/properties-binding-tutorial/binding.htm
        undoButton.setOnAction((event) -> {
            isNotUndo.setValue(false);
            System.out.println("\n\n>>>>>>>>click undo");
////            String undo = (String) cakeTaker.undoState();
////            Property property = myTextFieldProperty;
////            property.setValue(undo);
//            State state = cakeTaker.undoState();
//            if(state != null) {
//                Property property = mapProperty.get(state.getPropertyFieldName());
//                property.setValue(state.getValue());
//            }

            restoreFormState(cakeTaker.undoState());
//            FormSnapshot fs = cakeTaker.undoState();
//            mapProperty.forEach((k, v) -> {
//                        System.out.println(k + "->" + v);
//                        System.out.println("fs.getElementByPropertyName(k):" + fs.getElementByPropertyName(k));
//                        System.out.println("fs.getElementByPropertyName(k).getElementState():" + fs.getElementByPropertyName(k).getElementState());
//                        System.out.println("fs.getElementByPropertyName(k).getElementState().getState():" + fs.getElementByPropertyName(k).getElementState().getState());
//                        System.out.println("fs.getElementByPropertyName(k).getElementState().getState().getValue():" + fs.getElementByPropertyName(k).getElementState().getState().getValue());
//                        v.setValue(fs.getElementByPropertyName(k).getElementState().getState().getValue());
//                    }
//            );
        });

        redoButton.setOnAction((event) -> {
            isNotUndo.setValue(false);
            System.out.println("\n\n>>>>>>>>click redo");
//            myTextFieldProperty.set((String) cakeTaker.redoState());
            restoreFormState(cakeTaker.redoState());
        });
    }

    private FormState saveFormState(){
        return new FormState(myTextFieldProperty.getValue(), myCheckBoxProperty.getValue());
    }

    private void restoreFormState(FormState formState){
        if(formState != null){
            myTextFieldProperty.setValue(formState.getTextfield());
            myCheckBoxProperty.setValue(formState.isCheckbox());
        } else {
            myTextFieldProperty.setValue("");
            myCheckBoxProperty.setValue(false);
        }

    }
}
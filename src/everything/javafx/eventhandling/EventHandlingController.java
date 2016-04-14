package everything.javafx.eventhandling;

import everything.javafx.eventhandling.memento.per_form.FormState;
import everything.javafx.eventhandling.memento.per_form.UndoFormCakeTaker;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
    private BooleanProperty isNotUndo = new SimpleBooleanProperty(true);
    private BooleanProperty isUndoEmpty = new SimpleBooleanProperty(true);
    private BooleanProperty isRedoEmpty = new SimpleBooleanProperty(true);

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

    private void initializeUnRedoFramework(){
        System.out.println("initializeUnRedoFramework");
        undoButton.setDisable(isUndoEmpty.getValue());
        redoButton.setDisable(isRedoEmpty.getValue());
        isUndoEmpty.addListener((observable, oldValue, newValue) -> {
            System.out.println("isUndoEmpty.addListener-> observable: " + observable + ", oldValue: " + oldValue + ", newValue: " + newValue);
            if (newValue) {
                undoButton.setDisable(true);
            } else {
                undoButton.setDisable(false);
            }
        });

        isRedoEmpty.addListener((observable, oldValue, newValue) -> {
            System.out.println("isRedoEmpty.addListener-> observable: " + observable + ", oldValue: " + oldValue + ", newValue: " + newValue);
            if (newValue) {
                redoButton.setDisable(true);
            } else {
                redoButton.setDisable(false);
            }
            System.out.println("isRedoEmpty.addListener:" + newValue);
        });
        saveForm();
    }

    /**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
        initializeUnRedoFramework();
        // Handle Button event.
        myButton.setOnAction((event) -> {
            outputTextArea.appendText("Button Action\n");
        });

        // Handle CheckBox event.

        myCheckBox.setOnAction((event) -> {
            boolean selected = myCheckBox.isSelected();
            outputTextArea.appendText("CheckBox Action (selected: " + selected + ")\n");
//            cakeTaker.saveState(new BooleanStateMemento(CB_KEY, !selected));
            saveForm();
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
//            System.out.println(
//                    "EventHandlingController.myTextField.textProperty().addListener->cakeTaker.saveState:" + myTextFieldProperty.getValue());
            if (isNotUndo.getValue()/* && isNotRedo.getValue()*/) {
//                cakeTaker.saveState(new StringStateMemento(TF_KEY, newValue));
                saveForm();
            } else {
                isNotUndo.setValue(true);
//                isNotRedo.setValue(true);
            }
//            System.out.println(
//                    "EventHandlingController.myTextField.textProperty().addListener->myTextFieldProperty:" + myTextFieldProperty.getValue());
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

//            restoreForm();
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
//            restoreForm();
            restoreFormState(cakeTaker.redoState());
        });
    }

//    private void enableDisableUndoRedoBtn(){
//        if(cakeTaker.getUndoSize() == 0){
//            undoButton.setDisable(true);
//        }else{
//            undoButton.setDisable(false);
//        }
//
//        if(cakeTaker.getRedoSize() == 0){
//            redoButton.setDisable(true);
//        }else{
//            redoButton.setDisable(false);
//        }
//    }

    private void saveForm() {
        cakeTaker.saveState(new FormState(myTextField.getText(), myCheckBox.isSelected()));
        isUndoEmpty.setValue(cakeTaker.isUndoEmpty());
        isRedoEmpty.setValue(cakeTaker.isRedoEmpty());
    }


    private void restoreFormState(FormState formState){
        myTextField.setText(formState.getTextfieldValue());
        myCheckBox.setSelected(formState.getCheckboxValue());
        isUndoEmpty.setValue(cakeTaker.isUndoEmpty());
        isRedoEmpty.setValue(cakeTaker.isRedoEmpty());
    }
}
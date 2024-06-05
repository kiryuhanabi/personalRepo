package com.example.studentprofile;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class StudentProfileController {
    @javafx.fxml.FXML
    private ComboBox<String> nationalityCombobox;
    @javafx.fxml.FXML
    private RadioButton maleRadiobutton;
    @javafx.fxml.FXML
    private TextField idTextfield;
    @javafx.fxml.FXML
    private DatePicker dobDatePicker;
    @javafx.fxml.FXML
    private TextArea displayTextarea;
    @javafx.fxml.FXML
    private RadioButton femaleRadiobutton;
    @javafx.fxml.FXML
    private TextField nameTextfield;

    @javafx.fxml.FXML
    public void initialize() {
        nationalityCombobox.getItems().addAll("Bangladeshi", "Indian", "Tiny Hat");
        ToggleGroup toggleGroup = new ToggleGroup();
        maleRadiobutton.setToggleGroup(toggleGroup);
        femaleRadiobutton.setToggleGroup(toggleGroup);

    }

    @javafx.fxml.FXML
    public void createOnAction(ActionEvent actionEvent) {

        String name = nameTextfield.getText();
        String id = idTextfield.getText();
        String dob = dobDatePicker.getValue().toString();
        String nationality = nationalityCombobox.getValue();

        String gender;
        if (maleRadiobutton.isSelected()) {
            gender = "Male";

        } else {
            gender = "Female";
        }

    Student student = new Student(name,id,dob,nationality,gender);
    displayTextArea.appendText(student.toString());
    }
}
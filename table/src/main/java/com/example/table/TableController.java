package com.example.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

import javafx.scene.control.RadioButton;

import static java.lang.Integer.parseInt;

public class TableController implements Initializable {

    @FXML
    private TableColumn<Person,String> countryCol;

    @FXML
    private TextField countryNTextfield;

    @FXML
    private TextField firstNTextField;

    @FXML
    private TableColumn<Person, String > firstnameCol;

    @FXML
    private TextField secondNTextfield;

    @FXML
    private TableColumn<Person, String> secondnameCol;

    @FXML
    private TableView<Person> table;


    @FXML
    private TextField idTextfield;

    private List<Person> PersonList = new ArrayList<>();
    private ObservableList<Person> ObservablePersonList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Person, String> idCol;

    @FXML
    private TableColumn<Person, String> ageCol;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TableColumn<Person, String> majorCol;
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton majorRadioButton;
    @FXML
    private RadioButton countryRadioButton;
    @FXML
    private RadioButton ageRadioButton;
    @FXML
    private CheckBox notpaidCheckBox;
    @FXML
    private TableColumn<Person, String> statusCol;
    @FXML
    private CheckBox piadCheckBox;


    @FXML
    void clickOnAction(ActionEvent event) {
        String firstname = firstNTextField.getText();
        String secondname = secondNTextfield.getText();
        String countryname = countryNTextfield.getText();
        String id = idTextfield.getText();
        LocalDate dateOfBirth = datePicker.getValue();
        String major = comboBox.getValue();

        String status = "";

        if (piadCheckBox.isSelected()) {
            status = "Paid";
        }
        if (notpaidCheckBox.isSelected()) {
            if (!status.isEmpty()) {
                status += ", ";
            }
            status += "Not paid";
        }



        StringBuilder errors = new StringBuilder();

        if (firstname.isEmpty()){
            errors.append("the first name is empty.\n");

        }
        if (secondname.isEmpty()){
            errors.append("the second name is empty.\n");
        }

        if (countryname.isEmpty()){
            errors.append("the country name is empty.\n");

        }

        if (id.isEmpty()){
            errors.append("the id is empty.\n");
        } else if (!id.matches("\\d{7}")){
            errors.append("the id needs to be of 7 digits.\n");
        }

        if (dateOfBirth == null){
            errors.append("the date of birth is not selected.\n");
        }else {
            String age = calculateAge(dateOfBirth);
            int ageint = parseInt(age);
            if (ageint< 15){
                errors.append("select proper age!!.\n");
            }
        if (major == null ){
            errors.append("the major name is empty.\n");
        }
        }

        if (errors.length() > 0){
            showAlert("Validation error", errors.toString());
        } else {
            String age = calculateAge(dateOfBirth);
            PersonList.add(new Person(firstname,secondname,countryname,id,age,dateOfBirth,major,status));
            countryNTextfield.clear();
            firstNTextField.clear();
            secondNTextfield.clear();
            idTextfield.clear();
            datePicker.setValue(null);
            comboBox.setValue(null);
            piadCheckBox.setSelected(false);
            notpaidCheckBox.setSelected(false);
        }


    }

    private String calculateAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return "";
        }
        return String.valueOf(Period.between(dateOfBirth, LocalDate.now()).getYears());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        firstnameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        secondnameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("secondName"));
        countryCol.setCellValueFactory(new PropertyValueFactory<Person,String>("country"));
        idCol.setCellValueFactory(new PropertyValueFactory<Person,String>("id"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        majorCol.setCellValueFactory(new PropertyValueFactory<Person, String>("major"));
        comboBox.setItems(FXCollections.observableArrayList("CSE","MAT","CSC","EEE"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Person, String>("status"));





    }

    @FXML
    public void clearonAction(ActionEvent actionEvent) {
        table.getItems().clear();
    }

    private void showAlert(String Title,String Message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(Message);
        alert.showAndWait();

    }

    @FXML
    public void displayOnAction(ActionEvent actionEvent) {
        ObservablePersonList.clear();

        List<Person> filteredList = new ArrayList<>(PersonList);

        if (ageRadioButton.isSelected()) {
            filteredList = filteredList.stream()
                    .filter(Person -> Integer.parseInt(Person.getAge()) > 18)
                    .collect(Collectors.toList());
        } if (countryRadioButton.isSelected()) {
            filteredList = filteredList.stream()
                    .filter(Person -> "BD".equals(Person.getCountry()))
                    .collect(Collectors.toList());
        } if (majorRadioButton.isSelected()) {
            filteredList = filteredList.stream()
                    .filter(Person -> "MAT".equals(Person.getMajor()))
                    .collect(Collectors.toList());
        }

        ObservablePersonList.addAll(filteredList);
        table.setItems(ObservablePersonList);
    }
}

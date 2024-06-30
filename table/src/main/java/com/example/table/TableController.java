package com.example.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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

    ObservableList<Person> initialData(){

        Person p1 = new Person("Abir","Bangladesh","Shahriar");
        Person p2 = new Person("Nabil","Bangladesh","Safowan");
        return FXCollections. observableArrayList(p1,p2);
    }

    @FXML
    void clickOnAction(ActionEvent event) {
        Person newp = new Person(countryNTextfield.getText(),firstNTextField.getText(),secondNTextfield.getText());
        table.getItems().add(newp);
        countryNTextfield.clear();
        firstNTextField.clear();
        secondNTextfield.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        firstnameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        secondnameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("secondName"));
        countryCol.setCellValueFactory(new PropertyValueFactory<Person,String>("country"));

        table.setItems(initialData());

    }
}

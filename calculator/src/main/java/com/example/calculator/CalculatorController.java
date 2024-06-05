package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController
{
    @javafx.fxml.FXML
    private TextField firstText;
    @javafx.fxml.FXML
    private TextField secondText;
    @javafx.fxml.FXML
    private Label ansLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addonclick(ActionEvent actionEvent) {
        String n1 = firstText.getText();
        String n2 = secondText.getText();

        float num1 = Float.parseFloat(n1);
        float num2 = Float.parseFloat(n2);

        float num3 = num1 + num2;

        String n3 = Float.toString(num3);

        ansLabel.setText(n3);

    }

    @javafx.fxml.FXML
    public void mulonClick(ActionEvent actionEvent) {
        String n1 = firstText.getText();
        String n2 = secondText.getText();

        float num1 = Float.parseFloat(n1);
        float num2 = Float.parseFloat(n2);

        float num3 = num1 * num2;

        String n3 = Float.toString(num3);

        ansLabel.setText(n3);


    }

    @javafx.fxml.FXML
    public void divonClick(ActionEvent actionEvent) {
        String n1 = firstText.getText();
        String n2 = secondText.getText();

        float num1 = Float.parseFloat(n1);
        float num2 = Float.parseFloat(n2);

        if (num2 ==0) {
            ansLabel.setText("Can't be divided");
        }
        else{

            float num3 = num1 / num2;

            String n3 = Float.toString(num3);

            ansLabel.setText(n3);
        }


    }

    @javafx.fxml.FXML
    public void subonClick(ActionEvent actionEvent) {

        String n1 = firstText.getText();
        String n2 = secondText.getText();

        float num1 = Float.parseFloat(n1);
        float num2 = Float.parseFloat(n2);

        float num3 = num1 - num2;

        String n3 = Float.toString(num3);

        ansLabel.setText(n3);
    }

    @javafx.fxml.FXML
    public void clearonClick(ActionEvent actionEvent) {
        firstText.clear();
        secondText.clear();
        ansLabel.setText("");
    }
}
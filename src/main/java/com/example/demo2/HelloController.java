package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    public Label originalPrice;
    @FXML
    private Label priceLabel;
    @FXML
    private TextField priceField;
    @FXML
    private Label discountLabel;
    @FXML
    private TextField discountField;
    @FXML
    private Label resultLabel;


    @FXML
    void onCalculateButtonClick(ActionEvent event) {
        try{
            double price = Double.parseDouble(priceField.getText());
            double discount = Double.parseDouble(discountField.getText());

            double newPrice = price * (1 - discount / 100);

            resultLabel.setText("The new price of this item is " + newPrice + " dollars");
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers");
    }
}
}
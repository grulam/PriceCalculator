package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;

public class PriceCalculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label priceLabel = new Label("Enter original price");
        TextField priceField = new TextField();
        Label discountLabel = new Label("Enter discount %");
        TextField discountField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();

        // above user interface components
        // below layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setMinSize(400, 300);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(8);


        // adds UI components to the grid
        gridPane.add(priceLabel, 0, 0);
        gridPane.add(priceField, 1, 0);
        gridPane.add(discountLabel, 0, 1);
        gridPane.add(discountField, 1, 1);
        gridPane.add(calculateButton, 0, 2);
        gridPane.add(resultLabel, 1, 2);

        // setting an event handler to the button calculate
        // getting the user input from text field
        // calculating new price after discount
        // result label will print message if user entered wrong format
        // parseDouble meaning to convert a String value from the  text field to a double
        // try allows a block of code to be tested for error while executed
        // and catch, if an error occurs try the block
        calculateButton.setOnAction(event -> {
            try {
                double price = Double.parseDouble(priceField.getText());
                double discount = Double.parseDouble(discountField.getText());

                double newPrice = price * (1 - discount / 100);

                resultLabel.setText("The new price of this item is " + newPrice + " dollars");
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers");

            }


        });

        // create scene and stage

        Scene scene = new Scene(gridPane, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Discount Calculator");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}


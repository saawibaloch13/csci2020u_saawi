package com.example.demonew;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDate;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the TextArea
        TextField textField = new TextField();
        primaryStage.setTitle("Pizza Order");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        //creating label for FullName
        Label FullName = new Label("Full Name:");
        grid.add(FullName, 0, 2);
        //creating text field for full name
        TextField FullNameTextField = new TextField();
        //adding prompt text
        FullNameTextField.setPromptText("Full Name");
        grid.add(FullNameTextField, 1, 2);

        //creating label for E-mail
        Label EMail = new Label("E-mail:");
        grid.add(EMail, 0, 3);
        //creating text field for E-mail
        TextField EMailTextField = new TextField();
        //adding prompt text
        EMailTextField.setPromptText("E-mail");
        grid.add(EMailTextField, 1, 3);

        //creating label for Phone #
        Label PhoneNum = new Label("Phone #:");
        grid.add(PhoneNum, 0, 4);
        //creating text field for Phone #
        TextField PhoneNumTextField = new TextField();
        //adding prompt text
        PhoneNumTextField.setPromptText("Phone #");
        grid.add(PhoneNumTextField, 1, 4);

        //dough
        Label Dough = new Label("Dough Options");
        grid.add(Dough, 0, 5);
        final ComboBox DoughOptions = new ComboBox();
        DoughOptions.getItems().addAll(
                "Thin Dough",
                "Stuffed Dough",
                "Thick Dough");
        DoughOptions.setPromptText("Select One");
        grid.add(DoughOptions, 1, 5);

        //topping options
        Label topping = new Label("Topping Options");
        grid.add(topping, 0, 6);
        final ComboBox ToppingOptions = new ComboBox();
        ToppingOptions.getItems().addAll(
                "Cheese",
                "Pepperoni",
                "Mushrooms");
        ToppingOptions.setPromptText("Select One");
        grid.add(ToppingOptions, 1, 6);

        //sauce options
        Label sauce = new Label("Sauce Options");
        grid.add(sauce, 0, 7);
        final ComboBox SauceOptions = new ComboBox();
        SauceOptions.getItems().addAll(
                "Marinara Sauce",
                "Honey Siracha",
                "Garlic Parmesan");
        SauceOptions.setPromptText("Select One");
        grid.add(SauceOptions, 1, 7);

        //date picker for date
        DatePicker datePicker = new DatePicker();
        //label for date
        Label DatePick = new Label("Pick-up Date:");
        grid.add(DatePick, 0, 10);
        grid.add(datePicker, 1, 10);

        //Creating 'View Popular Orders'
        Button PopularOrders = new Button("View Popular Orders");
        HBox POBtn = new HBox(11);
        POBtn.setAlignment(Pos.TOP_LEFT);
        POBtn.getChildren().add(PopularOrders);
        grid.add(POBtn, 0, 1);

        HBox btnHb9 = new HBox();
        Text text = new Text("View our most popular orders!\n(Check console for list)");
        btnHb9.getChildren().add(text);
        grid.add(btnHb9,0,0);

        //Creating 'Place Order button'
        Button buttonRegis = new Button("Place Order");
        HBox hbBtn = new HBox(11);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(buttonRegis);
        grid.add(hbBtn, 1, 12);

        //when view popular order is pressed
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                System.out.println("Popular Orders:\n");
                Make cook = new MakePopular1();
                employee direct = new employee (cook);

                direct.MakePizza();
                Pizza pizza = cook.GetPizza();
                pizza.ShowPizza();

                cook = new MakePopular2();
                direct = new employee (cook);

                direct.MakePizza();
                pizza = cook.GetPizza();
                pizza.ShowPizza();

            }
        };

        //when the register button is clicked print the 4 fields
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //get the value of the fields that need to be printed

                String FullName = FullNameTextField.getText();
                String Email = EMailTextField.getText();
                String PhoneNum = PhoneNumTextField.getText();

                Object selectedItem = DoughOptions.getSelectionModel().getSelectedItem();
                Object selectedItem2 = SauceOptions.getSelectionModel().getSelectedItem();
                Object selectedIte3 = ToppingOptions.getSelectionModel().getSelectedItem();

                LocalDate date = datePicker.getValue();


                HBox btnHb = new HBox();
                Text text = new Text("Order Information:\nCustomer's Name:    "+FullName
                        +"\nE-Mail:    "+Email+"\nPhone #:    "+PhoneNum+"\nPick-up date:    "+date);
                btnHb.getChildren().add(text);
                grid.add(btnHb,0,15);

                HBox btnHb2 = new HBox();
                Text text2 = new Text("Order Details:\nDough:    "+selectedItem
                        +"\nSauce:    "+selectedItem2+"\nToping:    "+selectedIte3);
                btnHb2.getChildren().add(text2);
                grid.add(btnHb2,2,15);

            }
        };

        buttonRegis.setOnAction(event);
        PopularOrders.setOnAction(event2);
        Scene scene = new Scene(grid, 600, 700);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
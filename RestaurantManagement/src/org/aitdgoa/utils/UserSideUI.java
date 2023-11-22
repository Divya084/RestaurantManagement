
package org.aitdgoa.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserSideUI {
    
    static Stage userStage;
    static VBox centerLayout;
    static ChoiceBox<String> itemCategoryChoiceBox, locationChoiceBox;
    static DatePicker datePicker;
    static Label label;
    
    static Label msgLabel = new Label("");
    
    static int customerId;
    
    public static void userSideUI() throws FileNotFoundException
    {
        userStage = new Stage();
        
        BorderPane borderPane = new BorderPane();
        
        VBox sideBar = new VBox();
        sideBar.setAlignment(Pos.TOP_CENTER);
        sideBar.setPadding(new Insets(10,10,10,10));
        sideBar.setSpacing(40);
        sideBar.setPrefWidth(300);
        sideBar.setStyle("-fx-background-color: #090638;");
        
        FileInputStream fileInputStream1 = new FileInputStream("path300.png");
        Image logo = new Image(fileInputStream1);
        ImageView logoImageView = new ImageView(logo);
        logoImageView.setFitHeight(150);
        logoImageView.setFitWidth(120);
        
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.TOP_CENTER);
        vBox1.setSpacing(40);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(100);
        hBox.setPadding(new Insets(2,2,2,2));
        FileInputStream fileInputStream2 = new FileInputStream("6995500.png");
        Image menu = new Image(fileInputStream2);
        ImageView menuImageView = new ImageView(menu);
        menuImageView.setFitHeight(100);
        menuImageView.setFitWidth(150);
        hBox.getChildren().add(menuImageView);
        
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(2,2,2,2));
        hBox1.setPrefHeight(100);
        FileInputStream fileInputStream3 = new FileInputStream("user.png");
        Image edit = new Image(fileInputStream3);
        ImageView editImageView = new ImageView(edit);
        editImageView.setFitHeight(80);
        editImageView.setFitWidth(110);
        hBox1.getChildren().add(editImageView);
        
        borderPane.setLeft(sideBar);
        
        centerLayout = new VBox();
        centerLayout.setStyle("-fx-background-color: #91bbff;");
        borderPane.setCenter(centerLayout);
        centerLayout.setPadding(new Insets(20, 20, 20, 20));
        centerLayout.setSpacing(10);
        
        
        sideBar.getChildren().addAll(logoImageView , hBox, hBox1);
        
        Scene scene = new Scene(borderPane, 1500, 500);
        userStage.setScene(scene);
        userStage.show();
        
        //Actions on buttons
        hBox1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                centerLayout.getChildren().clear();
               
                Label uNameLabel = new Label("Name");
                TextField uNameTextField = new TextField();

                Label addressLabel = new Label("Address");
                TextField addressTextField = new TextField();

                Label phoneLabel = new Label("Phone Number");
                TextField phoneTextField = new TextField();
                
                Button edit = new Button("Edit");

                try {
                    String selectQuery = "select * from customer where cid=" + customerId;
                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
                    resultSet.next();
                    
                    uNameTextField.setText(resultSet.getString(2));
                    addressTextField.setText(resultSet.getString(4));
                    phoneTextField.setText(resultSet.getString(3));
                    
                } catch (Exception e) {}
                
                centerLayout.getChildren().addAll(uNameLabel, uNameTextField, addressLabel, addressTextField, phoneLabel, phoneTextField, edit);
                
                //***************************Action on edit button***************************
                edit.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.editUserDetails(uNameTextField.getText(), addressTextField.getText(), phoneTextField.getText());
                        userStage.close();
                        try {userSideUI();} catch (FileNotFoundException e) {}
                    }
                });
            }
        });
        
        hBox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) 
            {
                centerLayout.getChildren().clear();
                
                Button checkOut = new Button("Check Out");
                label = new Label("");
                
                itemCategoryChoiceBox = new ChoiceBox<>();
                itemCategoryChoiceBox.getItems().addAll("Starters", "Breakfast", "Lunch/Dinner", "Dessert");
                
                locationChoiceBox = new ChoiceBox<>();

                Label choiceLabel = new Label("Select food catagori");
                Label locationLabel = new Label("Select restaurent Location");
                
                Label dateLabel = new Label("Select todays date");
                datePicker = new DatePicker();
                
                //************************************************************************************
                    try {
                        ResultSet resultSet= Connection.statement.executeQuery("Select location from restaurent");
                        while(resultSet.next())
                            locationChoiceBox.getItems().add(resultSet.getString(1));
                    } catch (Exception e) {}
                //************************************************************************************

                HBox hBox = new HBox();
                hBox.getChildren().addAll(choiceLabel, itemCategoryChoiceBox, locationLabel, locationChoiceBox, dateLabel, datePicker);
                hBox.setSpacing(10);
                hBox.setAlignment(Pos.CENTER);
                
               HBox hBox1 = new HBox();
               hBox1.setSpacing(100);
               hBox1.getChildren().addAll(checkOut, label);
               

               centerLayout.getChildren().addAll(hBox, hBox1);
                
            //**********************Handaling events on choice box and button**********************
                itemCategoryChoiceBox.setOnAction(new EventHandler<ActionEvent>()  {

                    
                    @Override
                    public void handle(ActionEvent t) {
                        
                       if(itemCategoryChoiceBox.getValue() == "Starters")
                       {
                           CustomerMenu.starterMenu();
                       }
                       else if(itemCategoryChoiceBox.getValue() == "Breakfast")
                       {
                           CustomerMenu.breakfastMenu();
                       }
                       else if(itemCategoryChoiceBox.getValue() == "Lunch/Dinner")
                       {
                           CustomerMenu.lunch_dinnerMenu();
                       }
                       else
                       {
                           CustomerMenu.dessertMenu();
                       }
                    }
                });
                
                
                checkOut.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        if(itemCategoryChoiceBox.getValue() == null)
                        {
                            msgLabel.setText("Please select caltegory");
                            msgLabel.setTextFill(Color.web("Red"));
                        }
                        else if(locationChoiceBox.getValue() == null)
                        {
                            msgLabel.setText("Please select location");
                            msgLabel.setTextFill(Color.web("Red"));
                        }
                        else if(datePicker.getValue() == null)
                        {
                            msgLabel.setText("Please select date");
                            msgLabel.setTextFill(Color.web("Red"));
                        }
                        else if(Bill.totalAmount == 0)
                        {
                            msgLabel.setText("Please add items");
                            msgLabel.setTextFill(Color.web("Red"));
                        }
                        else
                        {
                            String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
                            Bill.bill(locationChoiceBox.getValue(), date);
 
                        }
                        
                    }
                });
                
            }
        });
        
        
        hBox.hoverProperty().addListener((ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            if (newValue) {
                hBox.setStyle("-fx-background-color: #91bbff;");
            } else {
                hBox.setStyle(null);
            }
        });

        hBox1.hoverProperty().addListener((ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            if (newValue) {
                hBox1.setStyle("-fx-background-color: #91bbff;");
            } else {
                hBox1.setStyle(null);
            }
        });
        
        
    }
}
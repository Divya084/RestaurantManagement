

package org.aitdgoa.utils;

import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Menu {
    static Stage userStage;
    static VBox sideBar,centerLayout;
    static GridPane itemdetail;
    public static void menufunction()
    {
    userStage = new Stage();
        
        BorderPane borderPane = new BorderPane();
        
        sideBar = new VBox();
        sideBar.setPadding(new Insets(100, 0 , 0 ,0));
        sideBar.setSpacing(30);
        sideBar.setPrefWidth(250);
        sideBar.setStyle("-fx-background-color: #090638;");
        borderPane.setLeft(sideBar);
        
        centerLayout = new VBox();
        centerLayout.setStyle("-fx-background-color: #91bbff;");
        borderPane.setCenter(centerLayout);
        centerLayout.setPadding(new Insets(20, 20, 20, 20));
        centerLayout.setSpacing(10);
        
        Button dispButton = new Button("Display Menu");
        dispButton.setPrefWidth(250);
        dispButton.setPrefHeight(50);
        Button AddButton = new Button("Add an item");
        AddButton.setPrefWidth(250);
        AddButton.setPrefHeight(50);
        Button DeleteButton = new Button("Delete an item");
        DeleteButton.setPrefWidth(250);
        DeleteButton.setPrefHeight(50);
        Button UpdateButton = new Button("Update an item");
        UpdateButton.setPrefWidth(250);
        UpdateButton.setPrefHeight(50);
        
        sideBar.getChildren().addAll(dispButton, AddButton,DeleteButton,UpdateButton);
        
        Scene scene = new Scene(borderPane, 1500, 500);
        userStage.setScene(scene);
        userStage.show();
        
        //Actions on buttons
        AddButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                centerLayout.getChildren().clear();
                
                GridPane gpane= new GridPane();
                gpane.setAlignment(Pos.CENTER);
            gpane.setPadding(new Insets(20, 20, 20 ,20));
            gpane.setVgap(10);
            gpane.setHgap(10);
                
               
                

                Label Itemid = new Label("Item Id");
                TextField ItemidText = new TextField();
                
                  Label Itemname = new Label("Item Name");
                TextField ItemnameText = new TextField();
                  
                   Label foodcategory = new Label("Select food category");
                  ChoiceBox<String> itemCategory = new ChoiceBox<>();
                itemCategory.getItems().addAll("Starters", "Breakfast", "Lunch/Dinner", "Dessert");

                Label Itemprice = new Label("Item price");
                TextField ItempriceText = new TextField();

        
                
                Button AddItem = new Button("Add");
                
                gpane.add(Itemid, 0, 0);
               gpane.add(ItemidText, 1, 0);
               gpane.add(Itemname, 0, 1);
               gpane.add(ItemnameText, 1, 1);
                gpane.add(foodcategory, 0, 2);
                 gpane.add(itemCategory, 1, 2);
                  gpane.add(Itemprice, 0, 3);
                   gpane.add(ItempriceText, 1, 3);
                    gpane.add(AddItem, 1, 4);
               
                

//                try {
//                    String insertitem = "insert into (itemid,name,category,price) values ";
//                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
//                    resultSet.next();
//                    
//                    uNameTextField.setText(resultSet.getString(2));
//                    addressTextField.setText(resultSet.getString(4));
//                    phoneTextField.setText(resultSet.getString(3));
//                    uPasswordField.setText(resultSet.getString(5));
//                    
//                } catch (Exception e) {}
//                
                centerLayout.getChildren().add(gpane);
                
                
                //***************************Action on edit button***************************
                AddItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.addItemToMenu(ItemidText.getText(), ItemnameText.getText(),itemCategory.getValue(),ItempriceText.getText());
                        userStage.close();
                        menufunction();
                       
                    }
                });
                
//                delete.setOnAction(new EventHandler<ActionEvent>() {
//
//                    @Override
//                    public void handle(ActionEvent t) {
//                        Query.deleteUserAccount();
//                    }
//                });
            }
        });
        DeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                centerLayout.getChildren().clear();
                
                HBox hboxdel=new HBox();
                hboxdel.setAlignment(Pos.CENTER);
                hboxdel.setSpacing(8);
                
            hboxdel.setPadding(new Insets(20, 20, 20 ,20));
                
                Label Deleteid = new Label("enter the Item id of the item which you want to delete");
                TextField DelText = new TextField();
                Button show = new Button("Show Item Details");
                Button DeleteItem = new Button("Delete");
                
                hboxdel.getChildren().addAll(Deleteid,DelText,show,DeleteItem);
                
                 show.setOnAction(new EventHandler<ActionEvent>() {
                   
                    @Override
                    public void handle(ActionEvent t) {
                        centerLayout.getChildren().remove(itemdetail);
                         itemdetail= new GridPane();
                         itemdetail.setAlignment(Pos.CENTER);
                         itemdetail.setPadding(new Insets(20, 20, 20 ,20));
                        itemdetail.setVgap(10);
                        itemdetail.setHgap(10);
                            
                         Label ItemId = new Label("Item Id");
                TextField ItemidText = new TextField();
                
                  Label Itemname = new Label("Item Name");
                TextField ItemnameText = new TextField();
                  
                   Label foodcategory = new Label("food category");
                   TextField foodcatg = new TextField();
                  

                Label Itemprice = new Label("Item price");
                TextField ItempriceText = new TextField();
                
                  itemdetail.add(ItemId, 0, 0);
               itemdetail.add(ItemidText, 1, 0);
               itemdetail.add(Itemname, 0, 1);
               itemdetail.add(ItemnameText, 1, 1);
                itemdetail.add(foodcategory, 0, 2);
                 itemdetail.add(foodcatg, 1, 2);
                  itemdetail.add(Itemprice, 0, 3);
                   itemdetail.add(ItempriceText, 1, 3);
                   
                   try {
                       int id=Integer.parseInt(DelText.getText());
                    String selectQuery = "select * from items where itemid=" + id;
                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
                    resultSet.next();
                    
                    ItemidText.setText(resultSet.getString(1));
                    ItemnameText.setText(resultSet.getString(2));
                    foodcatg.setText(resultSet.getString(3));
                    ItempriceText.setText(resultSet.getString(4));
                    
                } catch (Exception e) {}
                   
                   
                 centerLayout.getChildren().add(itemdetail);
            
                    }
                });
                
               centerLayout.getChildren().add(hboxdel);
                    
               
                

            
                
                
                DeleteItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.deleteItem(DelText.getText());
                        userStage.close();
                        menufunction();
                    }
                });
            }
        });
         UpdateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                centerLayout.getChildren().clear();
                
                HBox hboxdel=new HBox();
                hboxdel.setAlignment(Pos.CENTER);
                hboxdel.setSpacing(8);
                
            hboxdel.setPadding(new Insets(20, 20, 20 ,20));
                
                Label updeid = new Label("enter the Item id of the item which you want to update");
                TextField updText = new TextField();
                Button show = new Button("Show Item Details");
                Button updItem = new Button("Update");
                
                hboxdel.getChildren().addAll(updeid,updText,show,updItem);
                
                 show.setOnAction(new EventHandler<ActionEvent>() {
                   
                    @Override
                    public void handle(ActionEvent t) {
                        centerLayout.getChildren().remove(itemdetail);
                         itemdetail= new GridPane();
                         itemdetail.setAlignment(Pos.CENTER);
                         itemdetail.setPadding(new Insets(20, 20, 20 ,20));
                        itemdetail.setVgap(10);
                        itemdetail.setHgap(10);
                            
                         Label ItemId = new Label("Item Id");
                TextField ItemidText = new TextField();
                
                  Label Itemname = new Label("Item Name");
                TextField ItemnameText = new TextField();
                  
                   Label foodcategory = new Label("food category");
                   TextField foodcatg = new TextField();
                  

                Label Itemprice = new Label("Item price");
                TextField ItempriceText = new TextField();
                
                  itemdetail.add(ItemId, 0, 0);
               itemdetail.add(ItemidText, 1, 0);
               itemdetail.add(Itemname, 0, 1);
               itemdetail.add(ItemnameText, 1, 1);
                itemdetail.add(foodcategory, 0, 2);
                 itemdetail.add(foodcatg, 1, 2);
                  itemdetail.add(Itemprice, 0, 3);
                   itemdetail.add(ItempriceText, 1, 3);
                   
                   try
                   {
                       int id=Integer.parseInt(updText.getText());
                    String selectQuery = "select * from items where itemid=" + id;
                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
                    resultSet.next();
                    
                    ItemidText.setText(resultSet.getString(1));
                    ItemnameText.setText(resultSet.getString(2));
                    foodcatg.setText(resultSet.getString(3));
                    ItempriceText.setText(resultSet.getString(4));
                    
                } catch (Exception e) {}
                   
                   
                 centerLayout.getChildren().add(itemdetail);
                 
                 updItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.UpdateItem(ItemidText.getText(),ItemnameText.getText(),foodcatg.getText(),ItempriceText.getText());
                        userStage.close();
                        menufunction();
                    }
                });
            
                    }
                     
                });
                
               centerLayout.getChildren().add(hboxdel);
                    
            }
        });
        
        
        
        dispButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) 
            {
                centerLayout.getChildren().clear();
               
                
                ChoiceBox<String> itemCategoryChoiceBox = new ChoiceBox<>();
                itemCategoryChoiceBox.getItems().addAll("Starters", "Breakfast", "Lunch/Dinner", "Dessert");
                
                ChoiceBox<String> locationChoiceBox = new ChoiceBox<>();

                Label choiceLabel = new Label("Select food catagori");
                Label locationLabel = new Label("Select restaurent Location");
                
                
                //************************************************************************************
                    try {
                        ResultSet resultSet= Connection.statement.executeQuery("Select location from restaurent");
                        while(resultSet.next())
                            locationChoiceBox.getItems().add(resultSet.getString(1));
                    } catch (Exception e) {}
                //************************************************************************************

                HBox hBox = new HBox();
                hBox.getChildren().addAll(choiceLabel, itemCategoryChoiceBox, locationLabel, locationChoiceBox);
                hBox.setSpacing(10);
                hBox.setAlignment(Pos.CENTER);

                centerLayout.getChildren().addAll(hBox);
                
            //**********************Handaling events on choice box and button**********************
                itemCategoryChoiceBox.setOnAction(new EventHandler<ActionEvent>()  {

                    @Override
                    public void handle(ActionEvent t) {
                       if(itemCategoryChoiceBox.getValue() == "Starters")
                       {
                           MenuCategory.starterMenu();
                           
                       }
                       else if(itemCategoryChoiceBox.getValue() == "Breakfast")
                       {
                           MenuCategory.breakfastMenu();
                       }
                       else if(itemCategoryChoiceBox.getValue() == "Lunch/Dinner")
                       {
                           MenuCategory.lunch_dinnerMenu();
                       }
                       else
                       {
                           MenuCategory.dessertMenu();
                       }
                    }
                });
                

                
            }
        });
        
        
    }

    
}

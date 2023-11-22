
package org.aitdgoa.utils;

import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class location {
     static Stage userStage;
    static VBox sideBar,centerLayout,tableBox;
    static GridPane restaurantdetail;
    public static void restaurantlocation()
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
        borderPane.setCenter(centerLayout);
        centerLayout.setPadding(new Insets(20, 20, 20, 20));
        centerLayout.setSpacing(10);
        
        Button dispButton = new Button("Display all branches ");
        dispButton.setPrefWidth(250);
        dispButton.setPrefHeight(50);
        Button AddButton = new Button("Add a branch");
        AddButton.setPrefWidth(250);
        AddButton.setPrefHeight(50);
        Button DeleteButton = new Button("Delete a branch");
        DeleteButton.setPrefWidth(250);
        DeleteButton.setPrefHeight(50);
         Button UpdateButton = new Button("Update a branch");
        UpdateButton.setPrefWidth(250);
        UpdateButton.setPrefHeight(50);
        
        centerLayout.setStyle("-fx-background-color: #91bbff;");
        
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
               
                Label restid = new Label("Restaurant Id");
                TextField restText = new TextField();
                
                  Label restname = new Label("Resaturant branch");
                TextField restnameText = new TextField();
                
                Label restphno = new Label("Resaturant phone number");
                TextField restphnoText = new TextField();
                  
                 
                Button AddRest = new Button("Add");
                
                gpane.add(restid, 0, 0);
               gpane.add(restText, 1, 0);
               gpane.add(restname, 0, 1);
               gpane.add(restnameText, 1, 1);
                gpane.add(restphno, 0, 2);
                 gpane.add(restphnoText, 1, 2);
                  
                    gpane.add(AddRest, 1, 3);
               
            centerLayout.getChildren().add(gpane);
                
                
                //***************************Action on edit button***************************
                AddRest.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.addRestaurant(restText.getText(), restnameText.getText(),restphnoText.getText());
                        userStage.close();
                        restaurantlocation();
                       
                    }
                });
   
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
                
                Label Deleteid = new Label("enter the id of the restaurant branch which you want to delete");
                TextField DelText = new TextField();
                Button show = new Button("Show Branch Details");
                Button DeleteRest = new Button("Delete");
                
                hboxdel.getChildren().addAll(Deleteid,DelText,show,DeleteRest);
                
                 show.setOnAction(new EventHandler<ActionEvent>() {
                   
                    @Override
                    public void handle(ActionEvent t) {
                        centerLayout.getChildren().remove(restaurantdetail);
                         restaurantdetail= new GridPane();
                         restaurantdetail.setAlignment(Pos.CENTER);
                         restaurantdetail.setPadding(new Insets(20, 20, 20 ,20));
                        restaurantdetail.setVgap(10);
                        restaurantdetail.setHgap(10);
                        
                         Label restid = new Label("Restaurant Id");
                TextField restText = new TextField();
                
                  Label restname = new Label("Resaturant branch");
                TextField restnameText = new TextField();
                
                Label restphno = new Label("Resaturant phone number");
                TextField restphnoText = new TextField();

                  restaurantdetail.add(restid, 0, 0);
               restaurantdetail.add(restText, 1, 0);
               restaurantdetail.add(restname, 0, 1);
               restaurantdetail.add(restnameText, 1, 1);
                restaurantdetail.add(restphno, 0, 2);
                 restaurantdetail.add(restphnoText, 1, 2);
  
                   
                   try {
                       int id=Integer.parseInt(DelText.getText());
                    String selectQuery = "select * from restaurent where rid=" + id;
                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
                    resultSet.next();
                    
                    restText.setText(resultSet.getString(1));
                    restnameText.setText(resultSet.getString(2));
                    restphnoText.setText(resultSet.getString(3));
                    
                    
                } catch (Exception e) {}
                   
                   
                 centerLayout.getChildren().add(restaurantdetail);
            
                    }
                });
                
               centerLayout.getChildren().add(hboxdel);
        
                DeleteRest.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.deleteRestaurant(DelText.getText());
                        userStage.close();
                        restaurantlocation();
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
                
                Label updrid = new Label("enter the id of the restaurant branch which you want to update");
                TextField updText = new TextField();
                Button show = new Button("Show Restaurant Details");
                Button updrest = new Button("Update");
                
                hboxdel.getChildren().addAll(updrid,updText,show,updrest);
                
                 show.setOnAction(new EventHandler<ActionEvent>() {
                   
                    @Override
                    public void handle(ActionEvent t) {
                        centerLayout.getChildren().remove(restaurantdetail);
                         restaurantdetail= new GridPane();
                         restaurantdetail.setAlignment(Pos.CENTER);
                         restaurantdetail.setPadding(new Insets(20, 20, 20 ,20));
                        restaurantdetail.setVgap(10);
                        restaurantdetail.setHgap(10);
               
                    Label restid = new Label("Restaurant Id");
                TextField restText = new TextField();
                
                  Label restname = new Label("Resaturant branch");
                TextField restnameText = new TextField();
                
                Label restphno = new Label("Resaturant phone number");
                TextField restphnoText = new TextField();
                
                  restaurantdetail.add(restid, 0, 0);
               restaurantdetail.add(restText, 1, 0);
               restaurantdetail.add(restname, 0, 1);
               restaurantdetail.add(restnameText, 1, 1);
                restaurantdetail.add(restphno, 0, 2);
                 restaurantdetail.add(restphnoText, 1, 2);
                  
                   
                   try
                   {
                       int id=Integer.parseInt(updText.getText());
                    String selectQuery = "select * from restaurent where rid=" + id;
                    ResultSet resultSet = Connection.statement.executeQuery(selectQuery);
                    resultSet.next();
                    
                    restText.setText(resultSet.getString(1));
                    restnameText.setText(resultSet.getString(2));
                    restphnoText.setText(resultSet.getString(3));
                    
                } catch (Exception e) {}
                   
                   
                 centerLayout.getChildren().add(restaurantdetail);
                 
                 updrest.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        Query.updateRestaurant(restText.getText(),restnameText.getText(),restphnoText.getText());
                        userStage.close();
                       restaurantlocation();
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
                
                tableBox = new VBox();
                tableBox.setSpacing(10);
        
        
                LocationTabel.setTabelPropertiesRestaurant();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select rid,location,rphno from restaurent");
                while(resultSet.next())
                {
                 
                    LocationTabel.itemtable1.getItems().add(new locationdata(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                }
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(LocationTabel.itemtable1);
        
         centerLayout.getChildren().add(tableBox);
        
        }        
        });
        
        
    

                }
}

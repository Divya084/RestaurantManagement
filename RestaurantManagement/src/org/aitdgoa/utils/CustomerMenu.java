

package org.aitdgoa.utils;

import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CustomerMenu {
    static VBox tableBox;
    
    public static void starterMenu()
    {
        UserSideUI.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        Button add = new Button("Add");
        
        Tabel.setTabelPropertiesCustomer();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Starters'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1),"1"));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1, add, UserSideUI.msgLabel);
        
        UserSideUI.centerLayout.getChildren().add(tableBox);
         
        //**********Action On Add button************
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Bill.addToBill();
                UserSideUI.label.setText(""+Bill.count);
            }
        });
        
    }
    
    public static void breakfastMenu()
    {
        UserSideUI.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        Button add = new Button("Add");
        
        Tabel.setTabelPropertiesCustomer();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Breakfast'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1),"1"));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1, add, UserSideUI.msgLabel);
        
        UserSideUI.centerLayout.getChildren().add(tableBox);
        
        //**********Action On Add button************
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Bill.addToBill();
                UserSideUI.label.setText(""+Bill.count);
            }
        });
    }
    
    public static void lunch_dinnerMenu()
    {
        UserSideUI.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        Button add = new Button("Add");
        
        Tabel.setTabelPropertiesCustomer();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Lunch_Dinner'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1),"1"));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1, add,UserSideUI.msgLabel);
        
        UserSideUI.centerLayout.getChildren().add(tableBox);
        
        //**********Action On Add button************
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if(UserSideUI.itemCategoryChoiceBox.getValue() == null)
                {
                    UserSideUI.msgLabel.setText("Please select items");
                    UserSideUI.msgLabel.setTextFill(Color.web("Red"));
                }
                else if(UserSideUI.locationChoiceBox.getValue() == null)
                {
                    UserSideUI.msgLabel.setText("Please select location");
                    UserSideUI.msgLabel.setTextFill(Color.web("Red"));
                 }
                else if(UserSideUI.datePicker.getValue() == null)
                {
                    UserSideUI.msgLabel.setText("Please select date");
                    UserSideUI.msgLabel.setTextFill(Color.web("Red"));
                }
                else
                {
                    UserSideUI.msgLabel.setText("");
                    Bill.addToBill();
                    UserSideUI.label.setText(""+Bill.count);
                }
                   
            }
        });
    }
    
    public static void dessertMenu()
    {
        UserSideUI.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        Button add = new Button("Add");
        
        Tabel.setTabelPropertiesCustomer();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Dessert'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1),"1"));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1, add, UserSideUI.msgLabel);
        
        UserSideUI.centerLayout.getChildren().add(tableBox);
        
        //**********Action On Add button************
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Bill.addToBill();
                UserSideUI.label.setText(""+Bill.count);
            }
        });
    }
    
}

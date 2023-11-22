

package org.aitdgoa.utils;

import java.sql.ResultSet;

import javafx.scene.layout.VBox;

public class MenuCategory 
{
    static VBox tableBox;
    
    public static void starterMenu()
    {
        Menu.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        
        Tabel.setTabelPropertiesAdmin();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Starters'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1)));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1);
        
        Menu.centerLayout.getChildren().add(tableBox);
         
        
        
    }
    
    public static void breakfastMenu()
    {
        Menu.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
 
        Tabel.setTabelPropertiesAdmin();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Breakfast'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1)));
            } catch (Exception e) {
                System.out.println(e);
            }
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1);
        
        Menu.centerLayout.getChildren().add(tableBox);
    
    }
    
    public static void lunch_dinnerMenu()
    {
        Menu.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        
        
        Tabel.setTabelPropertiesAdmin();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Lunch_Dinner'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1)));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1);
        
        Menu.centerLayout.getChildren().add(tableBox);
        
        
    }
    
    public static void dessertMenu()
    {
        Menu.centerLayout.getChildren().remove(tableBox);
        
        tableBox = new VBox();
        tableBox.setSpacing(10);
        

        
        Tabel.setTabelPropertiesAdmin();
        
        //************************************************************************************
            try {
                ResultSet resultSet= Connection.statement.executeQuery("Select itemid, name, price from items where category='Dessert'");
                while(resultSet.next())
                    Tabel.itemtable1.getItems().add(new MenuItems1(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(1)));
            } catch (Exception e) {}
        //************************************************************************************
        
        tableBox.getChildren().addAll(Tabel.itemtable1);
        
        Menu.centerLayout.getChildren().add(tableBox);
        

    }
   
}

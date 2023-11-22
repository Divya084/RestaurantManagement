
package org.aitdgoa.utils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Tabel
{
    static TableView<MenuItems1> itemtable1; 
    
    public static void setTabelPropertiesAdmin()
    {
        itemtable1 = new TableView<>();
        
        TableColumn<MenuItems1, Integer> itemIdColumn = new TableColumn<>("ItemID");
        TableColumn<MenuItems1, String> itemNameColumn = new TableColumn<>("Item Name");
        TableColumn<MenuItems1, Integer> itemPriceColumn = new TableColumn<>("Price");
        
        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemid"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        itemtable1.getColumns().addAll(itemIdColumn, itemNameColumn, itemPriceColumn);
        
        itemtable1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    public static void setTabelPropertiesCustomer()
    {
        itemtable1 = new TableView<>();
        
        TableColumn<MenuItems1, Integer> itemIdColumn = new TableColumn<>("ItemID");
        TableColumn<MenuItems1, String> itemNameColumn = new TableColumn<>("Item Name");
        TableColumn<MenuItems1, Integer> itemPriceColumn = new TableColumn<>("Price");
        TableColumn<MenuItems1, String> itemChoiceColumn = new TableColumn<>("Choice");
        TableColumn<MenuItems1, String> itemQuantityColumn = new TableColumn<>("Quantity");
        
        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemid"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        itemChoiceColumn.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        itemQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("textField"));
        
        itemtable1.getColumns().addAll(itemIdColumn, itemNameColumn, itemPriceColumn,itemChoiceColumn,itemQuantityColumn);
        
        itemtable1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
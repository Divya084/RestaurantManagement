
package org.aitdgoa.utils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LocationTabel {
     static TableView<locationdata> itemtable1; 
    public static void setTabelPropertiesRestaurant()
    {
        itemtable1 = new TableView<>();
        
        TableColumn<locationdata, Integer> RestaurantIdColumn = new TableColumn<>("Restaurant ID");
        TableColumn<locationdata, String> BranchColumn = new TableColumn<>("Branch");
        TableColumn<locationdata, String> phnoColumn = new TableColumn<>("Phone number");
      
        RestaurantIdColumn.setCellValueFactory(new PropertyValueFactory<>("rid"));
        BranchColumn.setCellValueFactory(new PropertyValueFactory<>("branch"));
        phnoColumn.setCellValueFactory(new PropertyValueFactory<>("phno"));
      
        itemtable1.getColumns().addAll(RestaurantIdColumn, BranchColumn, phnoColumn);
        
        itemtable1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}

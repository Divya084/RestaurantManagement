package org.aitdgoa.utils;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Sales{
    static TableView<SalesData> salesTable; 
    
    public static void setTableSales()
    {
        salesTable = new TableView<>();
        
        TableColumn<SalesData, Integer> ridColumn = new TableColumn<>("Restaurant_id");
        TableColumn<SalesData, String> dateColumn = new TableColumn<>("Date");
        TableColumn<SalesData, String> locColumn = new TableColumn<>("Location");
        TableColumn<SalesData, Integer> amountColumn = new TableColumn<>("Amount");
        
        ridColumn.setCellValueFactory(new PropertyValueFactory<>("rid"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        locColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        salesTable.getColumns().addAll(ridColumn, locColumn, dateColumn, amountColumn);
        
        salesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

}
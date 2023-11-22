
package org.aitdgoa.utils;

import java.sql.ResultSet;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Record {
    static TableView<customerdata> RecordTable; 
    
    public static void setTableCustomer()
    {
        RecordTable = new TableView<>();
        
        TableColumn<customerdata, Integer> cidColumn = new TableColumn<>("Customer Id");
        TableColumn<customerdata, String> nameColumn = new TableColumn<>("Customer Name");
        TableColumn<customerdata, String> phnoColumn = new TableColumn<>("phone number");
        TableColumn<customerdata, String> addressColumn = new TableColumn<>("Address");

        cidColumn.setCellValueFactory(new PropertyValueFactory<>("cid"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("cname"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phnoColumn.setCellValueFactory(new PropertyValueFactory<>("phno"));


        RecordTable.getColumns().addAll(cidColumn, nameColumn,addressColumn, phnoColumn);
        
        try {
                ResultSet resultSet= Connection.statement.executeQuery("SELECT * from customerrecords");
                while(resultSet.next())
                {
                    RecordTable.getItems().add(new customerdata(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(4),resultSet.getString(3)));
                }
            } catch (Exception e) {Customer.loadPromptScreen("Failed");} 
        
        RecordTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}

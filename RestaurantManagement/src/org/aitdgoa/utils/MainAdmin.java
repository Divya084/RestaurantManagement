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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainAdmin {

    public static String getMonthString(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return "00";
        }
    }

    static Stage AdStage;
    static VBox vBox;
    static TextField totalAmount;
    static TextField maxAmount;
    static int sumOfAmount = 0;

    public static void Access() {
        AdStage = new Stage();

        Button m = new Button("Menu");
        Button loc = new Button("Restaurant Locations");
        Button sales = new Button("Sales");
        Label l1 = new Label("What you want to access?");

        vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));
        
        Button record = new Button("Customer Records");
        vBox.getChildren().addAll(l1, m, loc, sales,record);

        Scene scene = new Scene(vBox, 400, 400);
        AdStage.setScene(scene);
        AdStage.setTitle("Admin");
        AdStage.show();

        m.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                Menu.menufunction();
            }
        });

        sales.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChoiceBox<String> locations = new ChoiceBox<>();

                try 
                {
                    ResultSet resultSet1= Connection.statement.executeQuery("select location from restaurent;");
                    while(resultSet1.next()) {
                        locations.getItems().add(resultSet1.getString(1));
                }
                } catch (Exception e) {
                    System.out.println("Exception in admin sales" + e.toString());
                }
      
                locations.setValue("Mapusa");

                ChoiceBox<String> months = new ChoiceBox<>();
                months.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec");
                months.setValue("Jan");

                Button searchButton = new Button("Search");

                HBox.setHgrow(locations, Priority.ALWAYS);
                HBox.setHgrow(months, Priority.ALWAYS);
                HBox.setHgrow(searchButton, Priority.ALWAYS);
                locations.setMaxWidth(Double.MAX_VALUE);
                months.setMaxWidth(Double.MAX_VALUE);
                searchButton.setMaxWidth(Double.MAX_VALUE);
                
                HBox hBox1 = new HBox();
                hBox1.setSpacing(10);
                //totalAmount.setDisable(true);
                Label ta = new Label("Total Amount");
                totalAmount = new TextField();
                hBox1.getChildren().addAll(ta, totalAmount);
                
                HBox hBox2 = new HBox();
                hBox2.setSpacing(10);
                Label max = new Label("Restaurent with\nmaximum sales");
                ListView<String> listView = new ListView<String>();
                listView.setMaxSize(100, 150);
                try 
                {
                    ResultSet resultSet2 = Connection.statement.executeQuery("select o.rid, r.location from order1 o, orderdetails od, restaurent r where o.oid=od.oid "
                            + "and r.rid=o.rid GROUP by o.rid HAVING sum(od.amount*od.quantity)>= ALL(select sum(amount*quantity) from orderdetails GROUP by oid);");
                    while(resultSet2.next()) {
                        listView.getItems().add(resultSet2.getString(2));
                }
                } catch (Exception e) {
                    System.out.println("Exception in admin sales" + e.toString());
                }
                hBox2.getChildren().addAll(max, listView);

                HBox hBox = new HBox();
                hBox.getChildren().addAll(locations, months, searchButton);
                
                Sales.setTableSales();
                
                Stage salesStage = new Stage();
                
                VBox vbox = new VBox();
                vbox.setPadding(new Insets(10, 10, 10, 10));
                vbox.setSpacing(10);
                vbox.getChildren().addAll(hBox, Sales.salesTable, hBox1, hBox2);
                
                Scene scene = new Scene(vbox, 500, 600);
                salesStage.setTitle("Admin Sales");
                salesStage.setScene(scene);
                salesStage.show();
                
                searchButton.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t)
                    {
                        sumOfAmount = 0;
                        Sales.salesTable.getItems().clear();
                        try 
                        {
                            ResultSet resultSet= Connection.statement.executeQuery("SELECT o.rid, od.orddate, r.location, SUM(od.quantity*od.amount) as total FROM order1 o, orderdetails od, "
                                    + "restaurent r WHERE o.oid = od.oid and o.rid=r.rid and od.orddate like '__/" + getMonthString(months.getValue()) + "/____' "
                                    + "and r.location = '" + locations.getValue() + "' GROUP BY o.rid, od.orddate;");
                            
                            while(resultSet.next()) {
                                Sales.salesTable.getItems().add(new SalesData(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(1), resultSet.getInt(4)));
                                sumOfAmount += resultSet.getInt(4);
                        }
                        } catch (Exception e) {
                            System.out.println("Exception in admin sales" + e.toString());
                        }
                        totalAmount.setText(sumOfAmount + "");
                    }
                });
            }
            
        });
        
        loc.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                location.restaurantlocation();

            }

        });
        
        record.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                Record.setTableCustomer();
                Stage salesStage = new Stage();
                VBox vbox = new VBox();
                vbox.setPadding(new Insets(10, 10, 10, 10));
                vbox.getChildren().add(Record.RecordTable);
                Scene scene = new Scene(vbox, 800, 500);
                salesStage.setTitle("Customer records");
                salesStage.setScene(scene);
                salesStage.show();
                AdStage.close();

            }

        });

    }

}

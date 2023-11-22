

package org.aitdgoa.utils;

import java.io.FileNotFoundException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bill 
{
    static ObservableList<MenuItems1> menuItems;
    
    static int[] itemIds = new int[10];
    static String[] itemNames = new String[10];
    static int[] itemPrices = new int[10];
    static int[] itemQuantities = new int[10];
    static int count = 0;
    static int totalAmount = 0;
    
    static boolean var = false;
    
    public static void addToBill()
    {
        menuItems = Tabel.itemtable1.getItems();

        for(MenuItems1 item : menuItems)
        {
            if(item.getCheckBox().isSelected())
            {
                itemIds[count] = item.getItemid();
                itemNames[count] = item.getItemName();
                itemPrices[count] = item.getPrice();
                itemQuantities[count] = Integer.parseInt(item.getTextField().getText());
                totalAmount += (item.getPrice() * Integer.parseInt(item.getTextField().getText()));
                count++;
            }
                        
        }
    }
    
    public static void bill(String branchLocation, String date)
    {
        System.out.println(branchLocation + " " + date);
        Stage stage = new Stage();
        
        VBox billBox = new VBox();
        billBox.setPadding(new Insets(20, 20, 20, 20));
        billBox.setAlignment(Pos.CENTER);
        billBox.setSpacing(20);
        
        Button order = new Button("Place Order");
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        
        Text text1 = new Text("---------------------------------");
        Text text2 = new Text("|     Item     | price | quantity |");
        Text text3 = new Text("---------------------------------");
        vbox.getChildren().addAll(text1, text2, text3);
        for(int i=0; i<count; i++)
        {
            Text text4 = new Text("|   " + itemNames[i] + "       |   " + itemPrices[i] + "   |   " + itemQuantities[i] + "   |   ");
            Text text5 = new Text("---------------------------------");
            vbox.getChildren().addAll(text4, text5);
        }
        Text text6 = new Text("Total Amount : " + totalAmount);
        billBox.getChildren().addAll(vbox, text6, order);
        
        Scene scene = new Scene(billBox, 400, 500);
        stage.setScene(scene);
        stage.show();
        
        //*************Action on Order button******************//
        order.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Query.insertOrder(branchLocation, date);
                Customer.loadPromptScreen("Order has been placed");
                stage.close();
                UserSideUI.userStage.close();
                try {UserSideUI.userSideUI();} catch (FileNotFoundException ex) {}
            }
        });
        
    }
}
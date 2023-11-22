
package org.aitdgoa.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin {
     
    static Stage stage1;
    static VBox vBox1;
     static GridPane gridP;
   
     public static void Adminfunction()
     {
        
        
        //******************Tab1 contents*****************
        
             gridP = new GridPane();
            gridP.setAlignment(Pos.CENTER);
            gridP.setPadding(new Insets(20, 20, 20 ,20));
            gridP.setVgap(10);
            gridP.setHgap(10);

            Label nameLabel = new Label("Admin Name");
            TextField AdmnameText = new TextField();

            Label passwordLabel = new Label("Enter password");
            PasswordField Admpassword = new PasswordField();

            Button logInButton = new Button("Login");
            Button clearButton = new Button("Clear");

            gridP.add(nameLabel, 0, 0);
            gridP.add(AdmnameText, 1, 0);
            gridP.add(passwordLabel, 0, 1);
            gridP.add(Admpassword, 1, 1);
            gridP.add(logInButton, 0, 2);
            gridP.add(clearButton, 1, 2);
            

            vBox1 = new VBox();
           
            
        vBox1.setPadding(new Insets(30, 30, 30 ,30));
        vBox1.getChildren().add(gridP);

        Scene scene = new Scene(vBox1, 600, 400);
        stage1= new Stage();
        stage1.setScene(scene);
        stage1.setTitle("Admin Login");
        stage1.show();
        logInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String s=AdmnameText.getText();
                String p=Admpassword.getText();
         if(s.equals("Admin") && p.equals("admin123"))
       {
           Customer.loadPromptScreen("Login successfull");
           stage1.close();
           MainAdmin.Access();
        } 
       else
       {
           Customer.loadPromptScreen("User not identified");
       }
                    
            }
        });
       
        
}
}

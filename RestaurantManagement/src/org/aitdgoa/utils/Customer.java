package org.aitdgoa.utils;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Customer 
{
      static TabPane tabPane;
     static Tab tab1, tab2;
    static Stage stage1;
    static VBox vBox1;
     static GridPane gridP,gridPane2;
   
     public static void customerfunction()
     {
        tabPane = new TabPane();
        tabPane.setStyle("-fx-Border-style:solid");
        
        tab1 = new Tab("Login");
        tab1.setClosable(false);
        
        //******************Tab1 contents*****************
        
             gridP = new GridPane();
            gridP.setAlignment(Pos.CENTER);
            gridP.setPadding(new Insets(20, 20, 20 ,20));
            gridP.setVgap(10);
            gridP.setHgap(10);

            Label nameLabel = new Label("User Name");
            TextField nameTextField = new TextField();

            Label passwordLabel = new Label("Enter password");
            PasswordField passwordField = new PasswordField();

            Button logInButton = new Button("Login");
            Button clearButton = new Button("Clear");

            gridP.add(nameLabel, 0, 0);
            gridP.add(nameTextField, 1, 0);
            gridP.add(passwordLabel, 0, 1);
            gridP.add(passwordField, 1, 1);
            gridP.add(logInButton, 0, 2);
            gridP.add(clearButton, 1, 2);

            tab1.setContent(gridP);
        //*****************************************************
            
        tab2 = new Tab("Signup");
        tab2.setClosable(false);
        
        //******************Tab2 contents*********************
            gridPane2 = new GridPane();
            gridPane2.setAlignment(Pos.CENTER);
            gridPane2.setPadding(new Insets(20, 20, 20 ,20));
            gridPane2.setVgap(10);
            gridPane2.setHgap(10);

            Label uNameLabel = new Label("Enter Name");
            TextField uNameTextField = new TextField();

            Label addressLabel = new Label("Enter Address");
            TextField addressTextField = new TextField();

            Label phoneLabel = new Label("Phone number");
            TextField phoneTextField = new TextField();

            Label uPasswordLabel = new Label("Enter password");
            PasswordField uPasswordField = new PasswordField();

            Button signInButton = new Button("Sign in");
            Button uClearButton = new Button("Clear");

            gridPane2.add(uNameLabel, 0, 0);
            gridPane2.add(uNameTextField, 1, 0);
            gridPane2.add(addressLabel, 0, 1);
            gridPane2.add(addressTextField, 1, 1);
            gridPane2.add(phoneLabel, 0, 2);
            gridPane2.add(phoneTextField, 1, 2);
            gridPane2.add(uPasswordLabel, 0, 3);
            gridPane2.add(uPasswordField, 1, 3);
            gridPane2.add(signInButton, 0, 4);
            gridPane2.add(uClearButton, 1, 4);

            tab2.setContent(gridPane2);
        //****************************************************

        tabPane.getTabs().addAll(tab1, tab2);

        vBox1 = new VBox();
        vBox1.setPadding(new Insets(30, 30, 30 ,30));
        vBox1.getChildren().add(tabPane);

        Scene scene = new Scene(vBox1, 600, 400);
        stage1= new Stage();
        stage1.setScene(scene);
        stage1.show();
     
        //Actions on signin, login and clear button
        signInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                addUser(uNameTextField.getText(), addressTextField.getText(), phoneTextField.getText(), uPasswordField.getText());     
            }
        });
     
        
        logInButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int check = loginUser(nameTextField.getText(), passwordField.getText());
                if(check != 1)
                    stage1.close();
            }
        });
    
     }
    //Adding user to table
    public static void addUser(String name, String address, String phno, String password)
    {
        try 
        {
            ResultSet resultSet = Connection.statement.executeQuery("select cname, password from customer");
            while(resultSet.next())
            {
                if(resultSet.getString(1).equals(name) && resultSet.getString(2).equals(password))
                {
                    loadPromptScreen("You have already signed up please login");
                    return;
                }
                if(resultSet.getString(2).equals(password))
                {
                    loadPromptScreen("Pasword already taken");
                    return;
                }
            }
        } 
        catch (Exception e) {}
        
        //Inserting the customer in database
        String insertQuery = "insert into customer(cname, phno, address, password) values('" + name + "', '" + phno + "', '" + address + "', '" + password + "')";
        try{
            int count = Connection.statement.executeUpdate(insertQuery);
            System.out.println(count + " rows affected");
            loadPromptScreen("Sign in successfull"); 
        }
        catch(Exception e){}
    }
    
    public static int loginUser(String name, String password)
    {
        try 
        {
            ResultSet resultSet = Connection.statement.executeQuery("select cid from customer where cname='" + name + "' and password='" + password + "'");
            if(resultSet.next() == true)
            {
                UserSideUI.customerId = resultSet.getInt(1);
                loadPromptScreen("Login successfull");
                UserSideUI.userSideUI();
            }
            else
            {
                loadPromptScreen("No such user please sign in");
                return 1;
            }
                
            
        } 
        catch (Exception e) {System.out.println(e);}
        return 0;
    }
    
    public static void loadPromptScreen(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        alert.showAndWait();
    }

}

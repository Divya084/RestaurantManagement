

package org.aitdgoa.utils;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class Restaurant extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Vertical box for holding customer and admin buttons
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15));
        vbox.setAlignment(Pos.CENTER);

        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);

        Button admin = new Button("I own the app");
        Button customer = new Button("I am here to order");

        // Disabled background for the button
        admin.setBackground(null);
        customer.setBackground(null);

        // Set the font for the button
        admin.setFont(font);
        customer.setFont(font);

        // Hover effects for admin button
        admin.setOnMouseEntered(e -> admin.setStyle(
                "-fx-border-width: 2; -fx-border-color: #FFE4C4; -fx-background-color: #FFDAB9; -fx-text-fill: black;"));
        admin.setOnMouseExited(e -> admin.setStyle(null));
        admin.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Admin.Adminfunction();
                stage.close();
            }
        });

        // Hover effects for customer button
        customer.setOnMouseEntered(e -> customer.setStyle(
                "-fx-border-width: 2; -fx-border-color: #FFE4C4; -fx-background-color: #FFDAB9; -fx-text-fill: black;"));
        customer.setOnMouseExited(e -> customer.setStyle(null));
        customer.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Customer.customerfunction();
                stage.close();
            }
        });

        vbox.getChildren().addAll(admin, customer);

        Scene scene = new Scene(vbox, 500, 350);

        stage.setTitle("Restaurant Management App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Connection.setDatabaseConnection();
        launch();
    }

}
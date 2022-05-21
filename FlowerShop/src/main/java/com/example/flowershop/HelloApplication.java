/*
This program simulates a flower shop where the store manager can manage the store's flower stock and customers can
buy flowers.
In the GUI, there are 2 tabs: Manager View and Customer View.  The manager can see a list of all the flowers in stock, the
bulk price of each flower, the retail price of each flower, and the quantity in stock. The manager can order flowers, which
adds flowers to the inventory, and the manager can also delete/remove flowers from the inventory,

In the Customer View, customers can see all the flowers and the retail price, but they can't see the bulk price. Customers
can add flowers to a "shopping cart", remove flowers from this shopping cart, and when they are done shopping they can
purchase the flowers in their shopping cart. This removes the amount of flowers the customer bought from the inventory
(if there were 100 flowers and the customer bought 50 there are now 50 flowers in stock).

I have tested 3 methods using Junit ( the toString method from Flower class, and the toString and equals methods from
the flowerCart class). The tests for each method are in separate files.


 */
package com.example.flowershop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 500);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
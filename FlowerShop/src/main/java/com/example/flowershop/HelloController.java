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

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class HelloController {

    public ListView listManagerStock;
    public TextField getFlowerName;
    public TextField getFlowerColour;
    public TextField getFlowerBulk;
    public TextField getFlowerRetail;
    public Button btnOrderFlowers;
    public Button btnDeleteFlower;
    public Button btnUpdateInventory;
    public ListView listCustomerStock;
    public ListView listShoppingCart;
    public Button btnAddToCart;
    public Button btnRemoveFromCart;
    public Button btnPurchaseCart;
    public TextField getQuantity;
    public Store myStore = new Store();
    public Label labelBalance;
    public Label labelShoppingError;

    @FXML
    private void initialize() throws IOException {
        // this method uses data persistence to fill the customer and manager lists with all the flowers currently in stock

        myStore.updateStock(listManagerStock);
        listCustomerStock.getItems().clear();
        myStore.updateStockCustomer(listCustomerStock);


    }

    public void onManagerStockSelected(MouseEvent mouseEvent) {
        // the 'delete flower from stock' button is only visible when a stock item is selected
        btnDeleteFlower.setDisable(false);
        btnDeleteFlower.setVisible(true);
    }

    public void onFlowerOrder(ActionEvent actionEvent) throws IOException {
        boolean isInputValid = true;
        double bulkPrice;
        double retailPrice;
        try {
            bulkPrice = Double.parseDouble(getFlowerBulk.getText());
        }
        catch(ArithmeticException e){
            isInputValid = false;
        }
        try {
            retailPrice = Double.parseDouble(getFlowerRetail.getText());
        }
        catch(ArithmeticException e){
            isInputValid = false;
        }

        if (isInputValid){
            String name = getFlowerName.getText();
            String colour = getFlowerColour.getText();
            bulkPrice = Double.parseDouble(getFlowerBulk.getText());
            retailPrice = Double.parseDouble(getFlowerRetail.getText());
            Flower tempFlower = new Flower(name,colour,bulkPrice,retailPrice,100);
            FlowerCustomer tempFlowerCustomer = new FlowerCustomer(name,colour,bulkPrice,retailPrice,100);
            listManagerStock.getItems().add(tempFlower);
            listCustomerStock.getItems().add(tempFlowerCustomer);
            getFlowerName.clear();
            getFlowerRetail.clear();
            getFlowerBulk.clear();
            getFlowerColour.clear();

        }
    }

    public void onFlowerDelete(ActionEvent actionEvent) {
        Flower temp = (Flower) listManagerStock.getSelectionModel().getSelectedItem();
        listManagerStock.getItems().remove(temp);
        btnDeleteFlower.setDisable(true);
        btnDeleteFlower.setVisible(false); // this makes the button invisible when nothing is selected to avoid errors
    }

    public void onUpdateInventory(ActionEvent actionEvent) throws IOException {
        ObservableList<Flower> myList = listManagerStock.getItems();
        listCustomerStock.getItems().clear(); // clearing the list because it gets filled again later
        // now, the txt file (data persistence) is deleted then remade to avoid duplicate flowers.
        File flowerFile = new File("StoreStock.txt");
        flowerFile.delete();
        FileWriter fw = new FileWriter("StoreStock.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
        for (Flower f: myList){
            f.writeToFile(); // this adds each flower in the listview to the file
            FlowerCustomer temp = new FlowerCustomer(f.getName(),f.getColour(),f.getBulkPrice(),f.getRetailPrice(), f.getStoreQuantity());
            listCustomerStock.getItems().add(temp); // filling the customer listview
        }
    }

    public void onCustomerStockSelected(MouseEvent mouseEvent) {
        btnAddToCart.setVisible(true);
        btnAddToCart.setDisable(false);
        btnRemoveFromCart.setVisible(false);
        btnRemoveFromCart.setDisable(true);
    }

    public void onShoppingCartSelected(MouseEvent mouseEvent) {
        btnRemoveFromCart.setDisable(false);
        btnRemoveFromCart.setVisible(true);
        btnAddToCart.setVisible(false);
        btnAddToCart.setDisable(true);
    }

    public void onAddToCart(ActionEvent actionEvent) throws IOException {
        boolean isInputValid = true;
        ObservableList<FlowerCustomer> myList = listCustomerStock.getItems();
        int flowerIndex = listCustomerStock.getSelectionModel().getSelectedIndex();
        int qty = 0;
        try {
            qty = Integer.parseInt(getQuantity.getText());
        }
        catch(Exception e){
            isInputValid = false;
        }

        FlowerCustomer temp = myList.get(flowerIndex);
        if (isInputValid){
            myStore.addToCart(temp,listShoppingCart,qty,labelShoppingError);

        }
        getQuantity.clear();
        labelBalance.setText("Current Balance: $" + myStore.getShoppingBalance());

    }

    public void onRemoveFromCart(ActionEvent actionEvent) {
        FlowerCart temp = (FlowerCart) listShoppingCart.getSelectionModel().getSelectedItem();
        listShoppingCart.getItems().remove(temp);
        myStore.setShoppingBalance(myStore.getShoppingBalance()-(temp.getQtyOrder()*temp.getFlowerInCart().getRetailPrice()));
        ArrayList<FlowerCustomer> tempList = myStore.getShoppingFlowers();
        int tempIndex = tempList.indexOf(temp.getFlowerInCart());
        tempList.remove(tempIndex);
        myStore.setShoppingFlowers(tempList); // this removes the selected flower from the shoppingFlowers list
        labelBalance.setText("Current Balance: $" + myStore.getShoppingBalance());
    }

    public void onCartPurchase(ActionEvent actionEvent) throws IOException {
        // first, we need to decrease the quantity in stock of each flower by the amount the customer bought
        ObservableList<FlowerCart> cartList = listShoppingCart.getItems();
        ObservableList<FlowerCustomer> stockList = listCustomerStock.getItems();
        for (FlowerCart c: cartList){ // this for loop compares each flower in the cart to the flowers in stock to check which one it is
            for (FlowerCustomer f: stockList){
                int stockIndex = stockList.indexOf(f);
                FlowerCart temp = new FlowerCart(f,c.getQtyOrder());
                if (c.equals(temp)){ // if the flower in cart is the same as the one in store:
                    f.setStoreQuantity(f.getStoreQuantity()-c.getQtyOrder()); // this decreases the quantity in stock
                    listCustomerStock.getItems().set(stockIndex,f); // this refreshes the listview, since it doesn't automatically update
                }
            }
        }

        ObservableList<FlowerCustomer> myList = listCustomerStock.getItems();
        listManagerStock.getItems().clear();

        // now we have to update the file, since the quantity in stock has changed
        File flowerFile = new File("StoreStock.txt");
        flowerFile.delete();
        FileWriter fw = new FileWriter("StoreStock.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.close();
        for (FlowerCustomer f: myList){
            Flower temp = new Flower(f.getName(),f.getColour(),f.getBulkPrice(),f.getRetailPrice(), f.getStoreQuantity());
            temp.writeToFile();
            listManagerStock.getItems().add(temp);
        }

        listShoppingCart.getItems().clear();

        myStore.setShoppingBalance(0.00);
        myStore.getShoppingFlowers().clear();
        labelBalance.setText("Current Balance: $0.00");
    }
}
/*
This class represents the flower shop. It is used to read from the file "StoreStock.txt" and add those flowers to the
manager's list. It is also used to take flowerCustomer objects and add them to the shopping cart as flowerCart objects.


 */

package com.example.flowershop;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Flower> flowers = new ArrayList<>(); // this is used to fill the listviews with the file's flowers
    private static double shoppingBalance = 0; // this keeps track of the customer's balance
    private static ArrayList<FlowerCustomer> shoppingFlowers = new ArrayList<>(); // this keeps track of the flowers in the shopping cart
    public Store(){

    }
    public static void updateStock(ListView flowerList) throws IOException {
        flowerList.getItems().clear();
        flowers = createFlowers();
        for (Flower f: flowers){
            flowerList.getItems().add(f);

        }




    }
    public static void updateStockCustomer(ListView flowerList) throws IOException {
        flowerList.getItems().clear();
        flowers.clear();
        flowers = createFlowers();
        for (Flower f: flowers){
            FlowerCustomer temp = new FlowerCustomer(f.getName(),f.getColour(),f.getBulkPrice(),f.getRetailPrice(), f.getStoreQuantity());
            flowerList.getItems().add(temp);

        }




    }
    public static ArrayList createFlowers() throws IOException {
        // this method reads from the file, parses each line as a flower, and returns an arraylist of those flowers
        fr = new FileReader("StoreStock.txt");
        br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            parseFlowerStore(line);
        }

        return flowers;

    }


    public static void parseFlowerStore(String string ){
        // this parses a line from the file as a flower
        int c1 = string.indexOf(",");
        int c2 = string.indexOf(",",c1+1);
        int c3 = string.indexOf(",",c2+1);
        int c4 = string.indexOf(",",c3+1);

        String name = string.substring(0,c1);
        String colour = string.substring(c1+1,c2);
        Double bulkPrice = Double.parseDouble(string.substring(c2+1, c3));
        Double retailPrice = Double.parseDouble(string.substring(c3+1,c4));
        int storeQuantity = Integer.parseInt(string.substring(c4+1));

        flowers.add(new Flower(name, colour, bulkPrice, retailPrice,storeQuantity));
    }

    public static void addToCart(FlowerCustomer f, ListView customerCart, int qty, Label errorLabel){
        // the addToCart method doesn't run if the customer tries to buy more than the store has in stock
        // the addToCart method doesn't run if the customer already ordered that flower
        if (((qty == f.getStoreQuantity()) || (qty < f.getStoreQuantity()))&&(!shoppingFlowers.contains(f))){
            shoppingBalance += f.getRetailPrice()*qty;
            FlowerCart temp = new FlowerCart(f,qty);
            customerCart.getItems().add(temp);
            shoppingFlowers.add(f); // this keeps track of all the flowers in the cart, so that the customers don't add multiple orders of the same flower
            errorLabel.setText("");
        }
        else if (shoppingFlowers.contains(f)){
            errorLabel.setText("Flower Already In Cart");
        }
        else if (qty > f.getStoreQuantity()){
            errorLabel.setText("Not Enough Stock");
        }
    }



    public static double getShoppingBalance() {
        return shoppingBalance;
    }

    public static void setShoppingBalance(double shoppingBalance) {
        Store.shoppingBalance = shoppingBalance;
    }

    public static ArrayList<FlowerCustomer> getShoppingFlowers() {
        return shoppingFlowers;
    }

    public static void setShoppingFlowers(ArrayList<FlowerCustomer> shoppingFlowers) {
        Store.shoppingFlowers = shoppingFlowers;
    }

}

/*
This class also represents flowers in the flower shop, but this class is used in the list of flowers that the customers see.
This class is identical to the class "Flower", only the toString method is different (it does not include bulk price because
customers don't see the bulk price of a flower, only the retail price).

.
 */
package com.example.flowershop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FlowerCustomer {
    private String name;
    private String colour;
    private Double bulkPrice;
    private Double retailPrice;
    private int storeQuantity;

    public FlowerCustomer(String name, String colour, double bulkPrice, double retailPrice, int storeQuantity) {
        this.name = name;
        this.colour = colour;
        this.bulkPrice = bulkPrice;
        this.retailPrice = retailPrice;
        this.storeQuantity = storeQuantity;

    }

    public String toString() {
        return colour + " " + name + "; price: $" + retailPrice + "; " + storeQuantity + " in stock";
    }

    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter("StoreStock.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + "," + colour + "," + bulkPrice + "," + retailPrice + "\r");
        bw.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getBulkPrice() {
        return bulkPrice;
    }

    public void setBulkPrice(Double bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getStoreQuantity() {
        return storeQuantity;
    }

    public void setStoreQuantity(int storeQuantity) {
        this.storeQuantity = storeQuantity;
    }

}
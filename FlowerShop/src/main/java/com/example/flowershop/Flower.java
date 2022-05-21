/*
This class represents flowers in the flower shop. This class is used when the manager adds/deletes flowers to the stock
or saves the stock file.

This class contains the methods toString and writeToFile. the toString method overrides toString. the writeToFile method
is called when the user presses the "save to file" button, and it writes the flower to the file "StoreStock.txt".


 */

package com.example.flowershop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Flower {
    private String name;
    private String colour;
    private Double bulkPrice;
    private Double retailPrice;
    private int storeQuantity;

    public Flower(String name, String colour, double bulkPrice, double retailPrice, int storeQuantity){
        this.name = name;
        this.colour = colour;
        this.bulkPrice = bulkPrice;
        this.retailPrice = retailPrice;
        this.storeQuantity = storeQuantity;

    }

    public String toString(){
        return colour +" "+ name +  "; qty: " + storeQuantity + "; bulk price: $" + bulkPrice  +"; retail price: $" + retailPrice;
    }


    public void writeToFile() throws IOException {
        // this method takes a flower and adds it to the file
        FileWriter fw = new FileWriter("StoreStock.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ","+ colour + "," + bulkPrice+","+retailPrice+ ","+storeQuantity +"\r");
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

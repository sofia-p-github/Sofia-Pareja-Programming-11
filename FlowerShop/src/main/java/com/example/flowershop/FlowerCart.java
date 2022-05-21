/*
This class  represents the flowers that the customer has in their "shopping cart". It is used in the list of flowers
in the shopping cart that the customer can see.

It has 2 methods: a toString method and an equals method. Both of these methods override methods that already exist.

.
 */

package com.example.flowershop;

public class FlowerCart {
    private FlowerCustomer flowerInCart;
    private  int QtyOrder;

    public FlowerCart(FlowerCustomer flowerX, int qty){
        this.flowerInCart = flowerX;
        this.QtyOrder = qty;
    }

    public String toString(){
        return QtyOrder + " " + flowerInCart.getColour() + " "+ flowerInCart.getName() + "s $"  + flowerInCart.getRetailPrice() + " ea." ;
    }
    public boolean equals(FlowerCart c){
        if((this.getFlowerInCart() == c.getFlowerInCart() )&& this.getQtyOrder() == c.getQtyOrder()){
            return true;
        }
        return false;
    }

    public FlowerCustomer getFlowerInCart() {
        return flowerInCart;
    }

    public void setFlowerInCart(FlowerCustomer flowerInCart) {
        this.flowerInCart = flowerInCart;
    }

    public int getQtyOrder() {
        return QtyOrder;
    }

    public void setQtyOrder(int qtyOrder) {
        QtyOrder = qtyOrder;
    }
}

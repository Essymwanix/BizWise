package com.example.bizwise;

import java.io.Serializable;

public class Products implements Serializable
{
    private String id;
    private String productname;
    private String price;
    private String quantity;
    private String image;

    public Products(String productname, String price, String quantity, String image) {
        this.setImage(image);
        this.setId(getId());
        this.setProductname(productname);
        this.setPrice(price);
        this.setQuantity(quantity);
    }
    public Products(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

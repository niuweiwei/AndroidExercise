package cn.edu.hebtu.software.taobao.Bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Good implements Serializable{
    private int imageId;
    private String product;
    private String price;
    private String city;
    private String sell;
    private String user;
    private String comment;

    public Good(int imageId, String product, String price, String city, String sell, String user, String comment) {
        this.imageId = imageId;
        this.product = product;
        this.price = price;
        this.city = city;
        this.sell = sell;
        this.user = user;
        this.comment = comment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

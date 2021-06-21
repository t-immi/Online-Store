package ru.kandakov.onlinestore.dto;

public class Product {
    private int productId;
    private String label;
    private int price;

    public int getProductId() {
        return productId;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int productId, String label, int price) {
        this.productId = productId;
        this.label = label;
        this.price = price;

    }
}

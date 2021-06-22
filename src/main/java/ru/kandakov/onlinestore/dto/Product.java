package ru.kandakov.onlinestore.dto;

public class Product {
    private Long id;
    private String label;
    private int price;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(Long id, String label, int price) {
        this.id = id;
        this.label = label;
        this.price = price;

    }
}

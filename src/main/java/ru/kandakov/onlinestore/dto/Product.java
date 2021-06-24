package ru.kandakov.onlinestore.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
    private Long id;

    @NotNull(message = "Label should not be empty")
    @Size(min = 2, max = 50, message = "Name should be between 2 and 50 charters ")
    private String label;
    @Min(value = 0, message = "price should be more than 0")
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

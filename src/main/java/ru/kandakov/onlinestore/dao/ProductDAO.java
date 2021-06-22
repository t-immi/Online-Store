package ru.kandakov.onlinestore.dao;

import org.springframework.stereotype.Component;
import ru.kandakov.onlinestore.dto.Product;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDAO {
    private static long PRODUCT_COUNT;
    private List<Product> products = new ArrayList<>();
    {
        products = new ArrayList<>();

        products.add(0, new Product(++PRODUCT_COUNT, "карандаш", 10));
        products.add(1, new Product(++PRODUCT_COUNT, "ручка", 20));
        products.add(2, new Product(++PRODUCT_COUNT, "степлер", 50));
    }
    public List<Product> index() {
        return products;
    }

    public Product show(int id) {
        return products.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

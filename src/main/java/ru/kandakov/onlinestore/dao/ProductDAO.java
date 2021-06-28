package ru.kandakov.onlinestore.dao;

import org.springframework.stereotype.Component;
import ru.kandakov.onlinestore.dto.Product;

import java.util.HashMap;

@Component
public class ProductDAO {
    private static long PRODUCT_COUNT;

    HashMap<Long, Product> products = new HashMap<>();

    {
        products.put(0L, new Product(++PRODUCT_COUNT, "карандаш", 10));
        products.put(1L, new Product(++PRODUCT_COUNT, "ручка", 20));
        products.put(2L, new Product(++PRODUCT_COUNT, "степлер", 50));
    }

    public HashMap<Long, Product> index() {
        return products;
    }


    public Product show(long id) {
        return products.get(id);
    }

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public void update(Product product) {
        Product foundProduct = products.get(product.getId());
        if (foundProduct != null) {
            foundProduct.setLabel(product.getLabel());
            foundProduct.setPrice(product.getPrice());
        }
    }

    public void delete(long id) {
        products.remove(id);
    }

}
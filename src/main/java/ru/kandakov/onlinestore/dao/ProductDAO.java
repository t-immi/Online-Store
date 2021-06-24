package ru.kandakov.onlinestore.dao;

import org.springframework.stereotype.Component;
import ru.kandakov.onlinestore.dto.Product;

import java.util.ArrayList;
import java.util.Iterator;
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


    public Product show(long id) {
        return findById(id);
    }

    public void save(Product product) {
        products.add(product);
    }

    public void update(Product product) {
        Product foundProduct = findById(product.getId());
        if (foundProduct != null) {
            foundProduct.setLabel(product.getLabel());
            foundProduct.setPrice(product.getPrice());
        }
    }

    public void delete(long id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
            }
        }
    }
    private Product findById(long id) {
//      return products.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
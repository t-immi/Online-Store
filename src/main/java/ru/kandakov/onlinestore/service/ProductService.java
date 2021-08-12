package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product getById(Long id) {
        Product product = productRepository.getById(id);
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByLabelOrderByPriceAsc(String label) {
        return productRepository.findAllByLabelOrderByPriceAsc(label);
    }

    public Product delete(Product product) {
        productRepository.delete(product);
        return product;
    }
}


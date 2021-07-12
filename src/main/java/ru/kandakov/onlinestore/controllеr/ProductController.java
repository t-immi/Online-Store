package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.repository.ProductRepository;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product-catalog")
    public List<Product> outputProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/read/{id}")
    public Product show(@PathVariable long id) {
        return productRepository.getById(id);
    }

    @PutMapping("/product/create")
    @ResponseBody
    public Product save(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @PatchMapping("/product/update")
    @ResponseBody
    public Product update(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @DeleteMapping("/product/delete")
    @ResponseBody
    public Product delete(@RequestBody Product product) {
        productRepository.delete(product);
        return product;
    }
}
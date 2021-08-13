package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/catalog")
    public List<Product> outputProducts() {
        return productService.findAll();
    }

    @GetMapping("/read/{id}")
    public Product show(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/create")
    @ResponseBody
    public Product save(@RequestBody Product product) {
        return productService.create(product);
    }

    @PatchMapping("/update")
    @ResponseBody
    public Product update(@RequestBody Product product) {
        return productService.create(product);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Product delete(@RequestBody Product product) {
        return productService.delete(product);
    }

    @GetMapping("/read/min/{label}")
    public List<Product> readMinPrice(@PathVariable String label) {
        return productService.findAllByLabelOrderByPriceAsc(label);
    }
}
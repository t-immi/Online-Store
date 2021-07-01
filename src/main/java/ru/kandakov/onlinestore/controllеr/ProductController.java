package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.repository.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product-catalog")
    public String outputProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/catalog";
    }

    @GetMapping("/read/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.getById(id));
        return "product/show";
    }

    @PutMapping("/create")
    @ResponseBody
    public Product save(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @PatchMapping("/update")
    @ResponseBody
    public Product update(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Product delete(@RequestBody Product product) {
        productRepository.delete(product);
        return product;
    }
}
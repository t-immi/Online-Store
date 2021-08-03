package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.repository.ProductRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;
import ru.kandakov.onlinestore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository, ShoppingCartGoodsRepository shoppingCartGoodsRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
        this.productService = productService;
    }

    @GetMapping("/catalog")
    public List<Product> outputProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/read/{id}")
    public Product show(@PathVariable long id) {
        return productService.getById(id);
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
        shoppingCartGoodsRepository.deleteAll(product.getShoppingCartGoods());
        productRepository.delete(product);
        return product;
    }

    @GetMapping("/read/min/{label}")
    public List<Product> readMinPrice(@PathVariable String label){
        return productRepository.findAllByLabelOrderByPriceAsc(label);
    }
}
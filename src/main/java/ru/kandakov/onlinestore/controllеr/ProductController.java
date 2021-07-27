package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.repository.ProductRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, ShoppingCartGoodsRepository shoppingCartGoodsRepository) {
        this.productRepository = productRepository;
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }

    @GetMapping("/catalog")
    public List<Product> outputProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/read/{id}")
    public Optional<Product> show(@PathVariable long id) {
        return productRepository.findById(id);
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
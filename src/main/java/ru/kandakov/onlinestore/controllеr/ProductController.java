package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dao.ProductDAO;
import ru.kandakov.onlinestore.dto.Product;

@Controller
public class ProductController {

    private final ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/product-catalog")
    public String outputProducts(Model model) {
        model.addAttribute("products", productDAO.index());
        return "product/catalog";
    }

    @GetMapping("/read/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productDAO.show((int) id));
        return "product/show";
    }

    @PutMapping("/create")
    @ResponseBody
    public Product save(@RequestBody Product product) {
        productDAO.save(product);
        return product;
    }

    @PatchMapping("/update")
    @ResponseBody
    public Product update(@RequestBody Product product) {
        productDAO.update(product);
        return product;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Product delete(@RequestBody Product product) {
        productDAO.delete(product.getId());
        return product;
    }

}
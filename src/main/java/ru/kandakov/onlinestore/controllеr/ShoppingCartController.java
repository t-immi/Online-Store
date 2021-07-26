package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;

import java.util.List;
@RequestMapping("/shopping_cart")
@RestController
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;

    }

    @GetMapping("/catalog")
    public List<ShoppingCart> outputShoppingCart() {
        return shoppingCartRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public ShoppingCart save(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @PatchMapping("/update")
    @ResponseBody
    public ShoppingCart update(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ShoppingCart delete(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.delete(shoppingCart);
        return shoppingCart;
    }
}

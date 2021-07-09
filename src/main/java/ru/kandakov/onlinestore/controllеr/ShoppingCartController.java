package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.OrderRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;

@Controller
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, OrderRepository orderRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/shopping-cart-catalog")
    public String outputShoppingCart(Model model) {
        model.addAttribute("shopping_cart", shoppingCartRepository.findAll());
        return "shoppingCart/show";
    }

    @PutMapping("shopping_cart/create")
    @ResponseBody
    public ShoppingCart save(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @PatchMapping("/shopping_cart/update")
    @ResponseBody
    public ShoppingCart update(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    @DeleteMapping("/shopping_cart/delete")
    @ResponseBody
    public ShoppingCart delete(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartRepository.delete(shoppingCart);
        return shoppingCart;
    }
}

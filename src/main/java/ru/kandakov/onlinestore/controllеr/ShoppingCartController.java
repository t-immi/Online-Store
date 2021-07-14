package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;
import ru.kandakov.onlinestore.repository.OrderRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;

import java.util.List;

@RestController
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;
    private final OrderGoodsRepository orderGoodsRepository;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, OrderRepository orderRepository, OrderGoodsRepository orderGoodsRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.orderRepository = orderRepository;
        this.orderGoodsRepository = orderGoodsRepository;
    }

    @GetMapping("/shopping_cart_catalog")
    public List<ShoppingCart> outputShoppingCart() {
        return shoppingCartRepository.findAll();
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

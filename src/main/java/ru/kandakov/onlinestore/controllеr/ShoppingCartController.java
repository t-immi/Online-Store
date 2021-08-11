package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;
import ru.kandakov.onlinestore.service.CreateOrderByShoppingCartService;
import ru.kandakov.onlinestore.service.ShoppingCartService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/shopping_cart")
@RestController
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartService shoppingCartService;
    private final CreateOrderByShoppingCartService createOrderByShoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, ShoppingCartService shoppingCartService, CreateOrderByShoppingCartService createOrderByShoppingCartService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartService = shoppingCartService;
        this.createOrderByShoppingCartService = createOrderByShoppingCartService;
    }

    @GetMapping("/catalog")
    public List<ShoppingCart> outputShoppingCart() {
        return shoppingCartService.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public ShoppingCart create(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.create(shoppingCart);
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

    @GetMapping("/show/shopping_cart_goods")
    @ResponseBody
    public Set<ShoppingCartGoods> showShoppingCartGoods(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCart.getShoppingCartGoodsSet();
    }

    @GetMapping("/show/customer")
    @ResponseBody
    public Optional<Customer> getCustomerByShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.findCustomer(shoppingCart.getCustomerId());
    }

    @PutMapping("/create/order")
    public Order createOrderByShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        return createOrderByShoppingCartService.CreateOrderByShoppingCart(shoppingCart);
    }
}

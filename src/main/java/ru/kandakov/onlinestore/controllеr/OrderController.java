package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.repository.OrderRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, ShoppingCartGoodsRepository shoppingCartGoodsRepository) {
        this.orderRepository = orderRepository;
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> outputOrders(){
        return orderRepository.findAll();
    }
    @PutMapping("/order/create")
    @ResponseBody
    public Order save(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }

    @PatchMapping("/order/update")
    @ResponseBody
    public Order update(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }

    @DeleteMapping("/order/delete")
    @ResponseBody
    public Order delete(@RequestBody Order order) {
        orderRepository.delete(order);
        return order;
    }
}

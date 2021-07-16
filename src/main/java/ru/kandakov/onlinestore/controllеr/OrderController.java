package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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

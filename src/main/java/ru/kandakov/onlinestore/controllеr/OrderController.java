package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.repository.OrderRepository;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("")
    @ResponseBody
    public List<Order> outputOrders() {
        return orderRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public Order save(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }

    @PatchMapping("/update")
    @ResponseBody
    public Order update(@RequestBody Order order) {
        orderRepository.save(order);
        return order;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Order delete(@RequestBody Order order) {
        orderRepository.delete(order);
        return order;
    }
}

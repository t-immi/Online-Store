package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.repository.OrderRepository;

@Controller
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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

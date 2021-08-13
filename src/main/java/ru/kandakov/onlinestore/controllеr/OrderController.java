package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.service.OrderService;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Order> outputOrders() {
        return orderService.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public Order save(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PatchMapping("/update")
    @ResponseBody
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Order delete(@RequestBody Order order) {
        return orderService.delete(order);
    }
}

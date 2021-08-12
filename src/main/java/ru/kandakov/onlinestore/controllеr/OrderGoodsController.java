package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;
import ru.kandakov.onlinestore.service.OrderGoodsService;

import java.util.List;

@RequestMapping("/order_goods")
@RestController
public class OrderGoodsController {

    private final OrderGoodsRepository orderGoodsRepository;
    private final OrderGoodsService orderGoodsService;

    @Autowired
    public OrderGoodsController(OrderGoodsRepository orderGoodsRepository, OrderGoodsService orderGoodsService) {
        this.orderGoodsRepository = orderGoodsRepository;
        this.orderGoodsService = orderGoodsService;
    }

    @GetMapping("")
    @ResponseBody
    public List<OrderGoods> outputOrderGoods() {
        return orderGoodsService.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public OrderGoods save(@RequestBody OrderGoods orderGoods) {
        return orderGoodsService.create(orderGoods);
    }

    @PatchMapping("/update")
    @ResponseBody
    public OrderGoods update(@RequestBody OrderGoods orderGoods) {
        return orderGoodsService.create(orderGoods);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public OrderGoods delete(@RequestBody OrderGoods orderGoods) {
        return orderGoodsService.delete(orderGoods);
    }
}

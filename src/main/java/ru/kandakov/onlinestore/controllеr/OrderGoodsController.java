package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;

@RestController
public class OrderGoodsController {

    private final OrderGoodsRepository orderGoodsRepository;

    @Autowired
    public OrderGoodsController(OrderGoodsRepository orderGoodsRepository) {
        this.orderGoodsRepository = orderGoodsRepository;
    }
    @PutMapping("/order_goods/create")
    @ResponseBody
    public OrderGoods save(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }

    @PatchMapping("/order_goods/update")
    @ResponseBody
    public OrderGoods update(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }

    @DeleteMapping("/order_goods/delete")
    @ResponseBody
    public OrderGoods delete(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.delete(orderGoods);
        return orderGoods;
    }
}

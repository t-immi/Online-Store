package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;

import java.util.List;
@RequestMapping("/order_goods")
@RestController
public class OrderGoodsController {

    private final OrderGoodsRepository orderGoodsRepository;

    @Autowired
    public OrderGoodsController(OrderGoodsRepository orderGoodsRepository) {
        this.orderGoodsRepository = orderGoodsRepository;
    }

    @GetMapping("")
    @ResponseBody
    public List<OrderGoods> outputOrderGoods(){
        return orderGoodsRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public OrderGoods save(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }

    @PatchMapping("/update")
    @ResponseBody
    public OrderGoods update(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public OrderGoods delete(@RequestBody OrderGoods orderGoods) {
        orderGoodsRepository.delete(orderGoods);
        return orderGoods;
    }
}

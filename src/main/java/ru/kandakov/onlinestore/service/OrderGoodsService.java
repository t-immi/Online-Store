package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderGoodsService {

    private final OrderGoodsRepository orderGoodsRepository;

    @Autowired
    public OrderGoodsService(OrderGoodsRepository orderGoodsRepository) {
        this.orderGoodsRepository = orderGoodsRepository;
    }

    public OrderGoods create(OrderGoods orderGoods) {
        return orderGoodsRepository.save(orderGoods);
    }

    public OrderGoods update(OrderGoods orderGoods) {
         return orderGoodsRepository.save(orderGoods);
    }

    public List<OrderGoods> findAll() {
        return orderGoodsRepository.findAll();
    }

    public OrderGoods delete(OrderGoods orderGoods) {
        orderGoodsRepository.delete(orderGoods);
        return orderGoods;
    }
}


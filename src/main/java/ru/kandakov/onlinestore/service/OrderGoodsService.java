package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderGoodsService {

    private final OrderGoodsRepository orderGoodsRepository;

    @Autowired
    public OrderGoodsService(OrderGoodsRepository orderGoodsRepository) {
        this.orderGoodsRepository = orderGoodsRepository;
    }

    public OrderGoods create(OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }

    public OrderGoods update(OrderGoods orderGoods) {
        orderGoodsRepository.save(orderGoods);
        return orderGoods;
    }
}


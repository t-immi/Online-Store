package ru.kandakov.onlinestore.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class CreateOrderByShoppingCartService {
    private final OrderGoodsService orderGoodsService;
    private final OrderService orderService;
    private final ProductService productService;

    public CreateOrderByShoppingCartService(OrderGoodsService orderGoodsService, OrderService orderService, ProductService productService) {
        this.orderGoodsService = orderGoodsService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public Order CreateOrderByShoppingCart(@NotNull ShoppingCart shoppingCart) {

        long customerId = shoppingCart.getCustomerId();
        int sum = 0;
        Set<OrderGoods> orderGoodsSet = new HashSet<>();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setDateOfCreation(new Date());
        order.setStatus("заказ создан");

        for (ShoppingCartGoods shoppingCartGoods : shoppingCart.getShoppingCartGoodsSet()) {
            Product product = productService.getById(shoppingCartGoods.getProductId());
            if (product != null) {
                sum += product.getPrice();
                long productId = product.getProductId();

                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setProduct(product);
                orderGoods.setProductId(productId);
                orderGoods.setOrder(order);
                orderGoodsService.create(orderGoods);
                orderGoodsSet.add(orderGoods);
            }
        }
        order.setOrderGoodsSet(orderGoodsSet);
        order.setSum(sum);
        orderService.create(order);

        return order;
    }
}

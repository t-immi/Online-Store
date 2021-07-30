package ru.kandakov.onlinestore.service;

import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.*;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class CreateOrderByShoppingCartService {
    private final OrderGoodsService orderGoodsService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    public CreateOrderByShoppingCartService(OrderGoodsService orderGoodsService, OrderService orderService, ShoppingCartService shoppingCartService) {
        this.orderGoodsService = orderGoodsService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    public Order CreateOrderByShoppingCart(ShoppingCart shoppingCart){
        Product product = shoppingCart.getShoppingCartGoods().getProduct();
        Customer customer = shoppingCart.getCustomer();
        int price = product.getPrice();
        long id = product.getProductId();

        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setProduct(product);
        orderGoods.setProductId(id);
        orderGoodsService.create(orderGoods);

        Order order = orderGoods.getOrder();
        order.setOrderGoods(orderGoods);
        order.setSum(price);
        order.setDateOfCreation(new Date());
        order.setStatus("заказ создан");
        order.setCustomer(customer);
        orderService.create(order);

        orderGoods.setOrder(order);
        orderGoodsService.update(orderGoods);

        return order;
    }
}

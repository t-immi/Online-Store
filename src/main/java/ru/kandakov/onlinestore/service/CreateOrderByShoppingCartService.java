package ru.kandakov.onlinestore.service;

import org.jetbrains.annotations.NotNull;
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
    private final ProductService productService;
    private final CustomerService customerService;

    public CreateOrderByShoppingCartService(OrderGoodsService orderGoodsService, OrderService orderService, ShoppingCartService shoppingCartService, ProductService productService, CustomerService customerService) {
        this.orderGoodsService = orderGoodsService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.customerService = customerService;
    }

    public Order CreateOrderByShoppingCart(@NotNull ShoppingCart shoppingCart){

        long customerId = shoppingCart.getCustomerId();
        int sum = 0;

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setDateOfCreation(new Date());
        order.setStatus("заказ создан");

        for (ShoppingCartGoods shoppingCartGoods: shoppingCart.getShoppingCartGoodsSet()) {
            Product product = productService.getById(shoppingCartGoods.getProductId());
            if (product != null) {
                sum += product.getPrice();
                long productId = product.getProductId();

                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setProduct(product);
                orderGoods.setProductId(productId);
                orderGoods.setOrder(order);
                orderGoodsService.create(orderGoods);
                order.setOrderGoods(orderGoods);
            }
        }
        order.setSum(sum);
        orderService.create(order);

        return order;
    }
}

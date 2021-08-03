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
    private final ProductService productService;

    public CreateOrderByShoppingCartService(OrderGoodsService orderGoodsService, OrderService orderService, ShoppingCartService shoppingCartService, ProductService productService) {
        this.orderGoodsService = orderGoodsService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    public Order CreateOrderByShoppingCart(ShoppingCart shoppingCart){
        Product product = productService.getById(shoppingCart.getShoppingCartGoods().getProductId());
        Customer customer = shoppingCart.getCustomer();

        int price = product.getPrice();
        long productId = product.getProductId();
        long customerId = customer.getCustomerId();

        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setProduct(product);
        orderGoods.setProductId(productId);
        orderGoodsService.create(orderGoods);

        Order order = new Order();
        order.setOrderGoods(orderGoods);
        order.setSum(price);
        order.setDateOfCreation(new Date());
        order.setStatus("заказ создан");
        order.setCustomer(customer);
        order.setCustomerId(customerId);
        orderService.create(order);

        orderGoods.setOrder(order);
        orderGoodsService.update(orderGoods);

        return order;
    }
}

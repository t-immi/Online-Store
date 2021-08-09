package ru.kandakov.onlinestore.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.Order;
import ru.kandakov.onlinestore.dto.OrderGoods;
import ru.kandakov.onlinestore.dto.Product;
import ru.kandakov.onlinestore.dto.ShoppingCart;

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
        Product product = productService.getById(shoppingCart.getShoppingCartGoods().getProductId());

        if (product != null) {

            int price = product.getPrice();
            long productId = product.getProductId();
            long customerId = shoppingCart.getCustomerId();

            Order order = new Order();
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setProduct(product);
            orderGoods.setProductId(productId);
            orderGoods.setOrder(order);
            orderGoodsService.create(orderGoods);

            order.setOrderGoods(orderGoods);
            order.setSum(price);
            order.setDateOfCreation(new Date());
            order.setStatus("заказ создан");
            order.setCustomerId(customerId);
            orderService.create(order);

            orderGoodsService.update(orderGoods);

            return order;
        }
        return null;
    }
}

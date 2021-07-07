package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_goods_id", nullable = false, updatable = false, unique = true)
    private Long orderGoodsId;

    @Column(name = "order_id", nullable = false, updatable = false, unique = false)
    private Long orderId;

    @Column(name = "product_id", nullable = false, updatable = false, unique = false)
    private Long productId;

    @OneToOne(optional = false, mappedBy = "orderGoods")
    private Order order;

    @OneToMany (mappedBy = "orderGoods", fetch = FetchType.LAZY)
    private Collection<Product> products;

    public OrderGoods() {

    }

    public Long getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Long orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderGoods(Order order) {
        this.order = order;
    }

    public OrderGoods(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}

package ru.kandakov.onlinestore.dto;

import javax.persistence.*;

@Entity
@Table(name = "order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_goods_id", nullable = false, updatable = false, unique = true)
    private Long orderGoodsId;

    @Column(name = "order_id", nullable = false, updatable = false, unique = true)
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

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
}

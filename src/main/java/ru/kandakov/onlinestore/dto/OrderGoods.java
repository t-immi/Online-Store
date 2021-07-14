package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

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

    @JsonManagedReference
    @OneToOne(optional = true, mappedBy = "orderGoods")
    private Order order;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "order_goods_id", insertable = false, updatable = false)
    private Product product;

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

}

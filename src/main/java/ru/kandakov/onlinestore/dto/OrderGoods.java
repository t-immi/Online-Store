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

    @Column(name = "order_id", nullable = true, updatable = false)
    private Long orderId;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @JsonManagedReference(value = "orderGoods-order")
    @OneToOne(optional = true, mappedBy = "orderGoods")
    private Order order;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonBackReference(value = "product-orderGoods")
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

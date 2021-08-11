package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_goods_id", nullable = false, updatable = false, unique = true)
    private Long orderGoodsId;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

//    @JsonManagedReference(value = "orderGoods-order")
//    @OneToOne(optional = true, mappedBy = "orderGoods")
//    private Order order;

    @JsonBackReference(value = "order-orderGoods")
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonBackReference(value = "product-orderGoods")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public OrderGoods() {
    }

    public Long getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Long orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
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

    //    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public OrderGoods(Order order) {
//        this.order = order;
//    }

}

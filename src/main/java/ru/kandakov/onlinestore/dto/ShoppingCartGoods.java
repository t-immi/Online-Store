package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart_goods")
public class ShoppingCartGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_goods_id", nullable = false, updatable = false, unique = true)
    private Long shoppingCartGoodsId;

    @Column(name = "shopping_cart_id", nullable = false, updatable = false, unique = false)
    private Long shoppingCartId;

    @Column(name = "product_id",  nullable = false, updatable = false, unique = false)
    private Long productId;

    @OneToOne(optional=true, mappedBy="shoppingCartGoods")
    @JsonBackReference
    private ShoppingCart shoppingCart;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public ShoppingCartGoods() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Long getShoppingCartGoodsId() {
        return shoppingCartGoodsId;
    }

    public void setShoppingCartGoodsId(Long shoppingCartGoodsId) {
        this.shoppingCartGoodsId = shoppingCartGoodsId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

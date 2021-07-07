package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToOne(optional=false, mappedBy="shoppingCartGoods")
    private ShoppingCart shoppingCart;

    @OneToMany (mappedBy = "shoppingCartGoods", fetch = FetchType.LAZY)
    private Collection<Product> products;

    public ShoppingCartGoods() {
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCartGoods(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}

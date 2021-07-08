package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false, unique = true)
    private Long productId;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "price"/*, nullable = false*/)
    private int price;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", insertable = false, updatable = false)
//    private ShoppingCartGoods shoppingCartGoods;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<OrderGoods> orderGoods;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", insertable = false, updatable = false)
//    private OrderGoods orderGoods;
    @OneToMany (mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<ShoppingCartGoods> shoppingCartGoods;

    public Product(Collection<OrderGoods> orderGoods, Collection<ShoppingCartGoods> shoppingCartGoods) {
        this.orderGoods = orderGoods;

        this.shoppingCartGoods = shoppingCartGoods;
    }

    public Product(Long product_id, String label, int price, Collection<OrderGoods> orderGoods, Collection<ShoppingCartGoods> shoppingCartGoods) {
        this.productId = product_id;
        this.label = label;
        this.price = price;
        this.orderGoods = orderGoods;

        this.shoppingCartGoods = shoppingCartGoods;
    }

    public Collection<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Collection<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Collection<ShoppingCartGoods> getShoppingCartGoods() {
        return shoppingCartGoods;
    }

    public void setShoppingCartGoods(Collection<ShoppingCartGoods> shoppingCartGoods) {
        this.shoppingCartGoods = shoppingCartGoods;
    }

    public Long getProduct_id() {
        return productId;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long product_id){
        this.productId = product_id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}

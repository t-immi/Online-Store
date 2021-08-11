package ru.kandakov.onlinestore.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "online_order") //Таблицу нельзя называть order
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, updatable = false, unique = true)
    private Long orderId;

    @Column(name = "sum", nullable = false, updatable = false, unique = true)
    private int sum;

    @Column(name = "status", updatable = false, unique = true)
    private String status;

    @Column(name = "date_of_creation", nullable = false, updatable = false, unique = true)
    private Date dateOfCreation;

    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private long customerId;

    @JsonManagedReference(value = "order-orderGoods")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
//    @JoinColumn(name = "order_goods_id", insertable = false, updatable = false)
    private Set<OrderGoods> orderGoodsSet;

    @JsonBackReference(value = "customer-order")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    public Order() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderGoods> getOrderGoodsSet() {
        return orderGoodsSet;
    }

    public void setOrderGoodsSet(Set<OrderGoods> orderGoodsSet) {
        this.orderGoodsSet = orderGoodsSet;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}

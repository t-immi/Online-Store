package ru.kandakov.onlinestore.dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "online_order") //Таблицу нельзя называть order
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, updatable = false, unique = true)
    private Long orderId;

    @Column(name = "customer_id", nullable = false, updatable = false, unique = true)
    private Long customerId;

    @Column(name = "date_of_creation", nullable = false, updatable = false, unique = true)
    private Date dateOfCreation;

    @Column(name = "sum", nullable = false, updatable = false, unique = true)
    private int sum;

    @Column(name = "status", nullable = false, updatable = false, unique = true)
    private String status;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id", insertable = false, updatable = false)
//    private Customer customer;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private Collection<Customer> customers;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn (name = "order_goods_id")
    private OrderGoods orderGoods;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public OrderGoods getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(OrderGoods orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Order(OrderGoods orderGoods) {
        this.orderGoods = orderGoods;
    }
}

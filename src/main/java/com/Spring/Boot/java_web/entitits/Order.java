package com.Spring.Boot.java_web.entitits;


import com.Spring.Boot.java_web.entitits.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-'T' HH:mm:ss 'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    //Transformando em uma chave estrangeira
    @ManyToOne
    @JoinColumn(name = "client_id")
    //Implementando associação

    private User client;

    //mapeando
    //no OrderItem tenho um Id e o id tem o pedido
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    public Order(){
    }

    //Um pedido tem um pagamento
    //Ter o mesmo id se o produto tem id 5 o pagamento também vai ter id 5
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        super();
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment(){
        return moment;
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    public void setMoment(Instant moment){
        this.moment = moment;
    }
    public OrderStatus getOrderStatus(){
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getClient(){
        return client;
    }

    public void setClient(User client){
        this.client = client;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (((id == null)) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null)
            if (other.id != null)
                return false;
            else if (!id.equals(other.id))
                return false;
        return true;
    }
}

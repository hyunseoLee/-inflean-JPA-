package hellojpa;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    /* ManyToOne 또는 OneToOne 연관관계는 즉시로딩이 기본값이기 때문에 지연로딩으로 변경 필수 ! */
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    /* ManyToOne 또는 OneToOne 연관관계는 즉시로딩이 기본값이기 때문에 지연로딩으로 변경 필수 ! */
    @JoinColumn(name="ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

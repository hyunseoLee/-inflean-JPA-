package hellojpa;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    /* ManyToOne 또는 OneToOne 연관관계는 즉시로딩이 기본값이기 때문에 지연로딩으로 변경 필수 ! */
    private Order order;

    @Embedded
    private Address address; 


}

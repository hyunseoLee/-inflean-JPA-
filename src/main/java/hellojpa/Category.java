package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue
    @Column(name= "CATEGORY_ID")
    private Long id;

    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM",
        joinColumns = @JoinColumn(name="CATEGORY_ID"),
        inverseJoinColumns = @JoinColumn(name="ITEM_ID")
    )
    private List<Item> items= new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    /* ManyToOne 연관관계는 즉시로딩이 기본값이기 때문에 지연로딩으로 변경 필수 ! */
    @JoinColumn(name="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child= new ArrayList<>();



}

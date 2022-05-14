package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    @Column(name= "name")
    private String name;
    private Integer age;

    @Embedded
    private Address address;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

   // @Enumerated(EnumType.STRING)
   // private RoleType roleType; //회원구분

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate; //회원가입일

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate; //수정일

    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}


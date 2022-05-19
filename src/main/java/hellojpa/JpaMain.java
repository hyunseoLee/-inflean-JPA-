package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain  {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            System.out.println("==========");
            Member member= new Member();
            member.setName("userA");
            em.persist(member);

            /*반환 타입이 명확할 때*/
            TypedQuery<Member> members = em.createQuery("select m from Member m", Member.class);
            /*반환 타입이 명확하지 않을 때*/
            Query query = em.createQuery("select m.name, m.age from Member m");
            List<Member> resultList = members.getResultList();

            //1. JPQL 사용
            List<Member> members2 = em.createQuery("select m from Member m", Member.class)
                                    .getResultList();


            //2. QueryDSL 사용




            em.flush();
            em.clear();
            System.out.println("==========");
            Member member1 = em.find(member.getClass(), member.getId());
            System.out.println(member1.getId());


            tx.commit();

        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        };


        emf.close();
    }
}

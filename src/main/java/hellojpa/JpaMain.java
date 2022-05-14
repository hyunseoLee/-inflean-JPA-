package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

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
            /* 1. 회원 가입
            Member member = new Member();
            member.setId(2L);
            member.setName("userB");
            em.persist(member);
             */

            /* 2. 회원 조회 */
            Member member = em.find(Member.class, "1L");
            System.out.println("memberId = " + member.getId());
            System.out.println("memberName = " + member.getName());

            /* 3. 회원 삭제 */
            em.remove(member);

            /* 4. 회원 수정 */

            member.setName("memberA");
            // em.persist(member);  -> 할 필요가 없다.

            /* 다건 조회*/
            List<Member> result = em.createQuery("select m from Member as m ", Member.class)
                    .getResultList();
            for(Member memberList : result){
                System.out.println("member = " + memberList.getId());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        };


        emf.close();
    }
}


package DAO;

import Entities.Waiter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WaiterController {

    @PersistenceContext(unitName = "com.mycompany_cafe_manager_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void createOrUpdate(Waiter waiter) {
        em.merge(waiter);
    }
    
    public Waiter find(int id){
      return em.find(Waiter.class,id);
    }
    
    public List<Waiter> findAll(){
       return em.createQuery("SELECT waiter FROM Waiter waiter", Waiter.class).getResultList();
    }
    
       
    public void delete(int id){
        Waiter waiter = this.find(id);
        if(waiter != null){
            em.remove(waiter);
        }
    }
    
}

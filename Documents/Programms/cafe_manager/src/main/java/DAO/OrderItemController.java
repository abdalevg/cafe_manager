
package DAO;

import Entities.OrderItem;
import Entities.Waiter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderItemController {
 
    @PersistenceContext(unitName = "com.mycompany_cafe_manager_war_1.0-SNAPSHOTPU")
    private EntityManager em;
 
    public void createOrUpdate(OrderItem order) {
        em.merge(order);        
    }
    
    public OrderItem find(int id){
      return em.find(OrderItem.class,id);
    }
    
    public List<OrderItem> findAll(){
       return em
                .createQuery("SELECT order FROM OrderItem order", OrderItem.class)
                .getResultList();
    }
    
    
    
    public void delete(int id){
        OrderItem order = this.find(id);
        if(order != null){
            em.remove(order);
        }
    }
    
    
    
    
    
}

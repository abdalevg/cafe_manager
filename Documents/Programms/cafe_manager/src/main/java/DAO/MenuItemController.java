
package DAO;

import Entities.MenuItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MenuItemController {

    @PersistenceContext(unitName = "com.mycompany_cafe_manager_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    public void createOrUpdate(MenuItem menu) {
        em.merge(menu);
    }
    
    public MenuItem find(int id){
      return em.find(MenuItem.class,id);
    }
    
    public List<MenuItem> findAll(){
       return em
                .createQuery("SELECT menu FROM MenuItem menu", MenuItem.class)
                .getResultList();
    }
    
    public void delete(int id){
        MenuItem menu = this.find(id);
        if(menu != null){
            em.remove(menu);
        }
    }
    
}

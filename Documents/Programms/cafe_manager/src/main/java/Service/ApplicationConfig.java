
package Service;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        
        Set<Class<?>> resources = new java.util.HashSet<>();
    
        resources.add(Service.WaiterFacade.class);
        resources.add(Service.MenuItemFacade.class);
        resources.add(Service.OrderItemFacade.class);
        
        return resources;
    }
    
    
    
    
}

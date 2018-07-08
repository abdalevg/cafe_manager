

package Service;

import DAO.MenuItemController;
import DTO.MenuItemDTO;
import Entities.MenuItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
    


@Stateless
@Path("/menuItem")
public class MenuItemFacade {

    @EJB
    private MenuItemController controller;
           
    
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createOrUpdate(MenuItemDTO menuDTO){
        controller.createOrUpdate(MenuItemEntitytoDtoConverter.DtoToEntity(menuDTO));
    }
    
    
    
    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id){
        controller.delete(id);
    }
    
   @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public MenuItemDTO find(@PathParam("id") int id){
      return MenuItemEntitytoDtoConverter.EntityToDto(controller.find(id));
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<MenuItemDTO> findAll(){
       
       Collection<MenuItemDTO> result = new ArrayList<>();
        
       for(MenuItem menuItem: controller.findAll()){
           result.add(MenuItemEntitytoDtoConverter.EntityToDto(menuItem));
       }
       
       return result; 
        
       
    }
    
    
}

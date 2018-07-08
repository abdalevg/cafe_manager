
package Service;

import DAO.WaiterController;
import DTO.WaiterDTO;
import Entities.Waiter;
import java.util.ArrayList;
import java.util.Collection;
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
@Path("/waiter")
public class WaiterFacade {

    @EJB
    private WaiterController controller;
       
   
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createOrUpdate(WaiterDTO waiterDTO){
        controller.createOrUpdate(WaiterEntityDtoConverter.DtoToEntity(waiterDTO));
    }
        
    
    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id){
       controller.delete(id);
    }
            
            
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public WaiterDTO find(@PathParam("id") int id){
      return WaiterEntityDtoConverter.EntityToDto(controller.find(id));
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<WaiterDTO> findAll(){
        
       Collection<WaiterDTO> result = new ArrayList<>();
        
       for(Waiter waiter: controller.findAll()){
           result.add(WaiterEntityDtoConverter.EntityToDto(waiter));
       }
       
       return result;
    }
}

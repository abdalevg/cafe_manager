
package Service;

import DAO.OrderItemController;
import DTO.OrderItemDTO;
import DTO.WaiterDTO;
import Entities.OrderItem;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/orderItem")
public class OrderItemFacade{

    
    @EJB
    private OrderItemController controller;
    
        
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createOrUpdate(OrderItemDTO orderDTO){
        controller.createOrUpdate(OrderItemEntityDtoConverter.DtoToEntity(orderDTO));
    }
        
    
    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") int id){
        controller.delete(id);
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public OrderItemDTO find(@PathParam("id") int id){
        return OrderItemEntityDtoConverter.EntityToDto(controller.find(id));
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<OrderItemDTO> findAll(){
        
       Collection<OrderItemDTO> result = new ArrayList<>();
        
       for(OrderItem orderItem: controller.findAll()){
           result.add(OrderItemEntityDtoConverter.EntityToDto(orderItem));
       }
       
       return result;
        
    } 
   
    
    
}

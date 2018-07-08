
package Service;

import DTO.WaiterDTO;
import DTO.MenuItemDTO;
import DTO.OrderItemDTO;
import Entities.Waiter;
import Entities.MenuItem;
import Entities.OrderItem;
import java.util.ArrayList;
import java.util.List;


public class OrderItemEntityDtoConverter {
 
    
    
    public static OrderItem DtoToEntity(OrderItemDTO dto){
        
        
        
        OrderItem entity = new OrderItem();
        
        entity.setId(dto.getId());
        entity.setOrderTime(dto.getOrderTime());
        entity.setTableNumber(dto.getTableNumber());
        entity.setIsPaid(dto.isIsPaid());
        
        Waiter waiter = new Waiter();
                
        if(dto.getWaiter()!=null)
           waiter = WaiterEntityDtoConverter.DtoToEntity(dto.getWaiter());
              
        entity.setWaiter(waiter);
        
        List<MenuItem> menuItems = new ArrayList<>();
        
        if(dto.getMenuItems()!=null){
         for(MenuItemDTO itemDTO: dto.getMenuItems() ){
             MenuItem item = MenuItemEntitytoDtoConverter.DtoToEntity(itemDTO);
             menuItems.add(item);
         }
        
         entity.setMenuItems(menuItems);
        }
        
        return entity;
    
    }
    
    public static OrderItemDTO EntityToDto(OrderItem entity){
        
        OrderItemDTO dto = new OrderItemDTO();
        
        dto.setId(entity.getId());
        dto.setIsPaid(entity.isIsPaid());
        dto.setOrderTime(entity.getOrderTime());
        dto.setTableNumber(entity.getTableNumber());
        
        WaiterDTO waiterDTO = new WaiterDTO();
        
        if(entity.getWaiter()!=null)
            waiterDTO = WaiterEntityDtoConverter.EntityToDto(entity.getWaiter());
        
        dto.setWaiter(waiterDTO);
        
        List<MenuItemDTO> menuItemsDTO = new ArrayList<>();
        
        for(MenuItem item: entity.getMenuItems() ){
            MenuItemDTO itemDTO = MenuItemEntitytoDtoConverter.EntityToDto(item);
            menuItemsDTO.add(itemDTO);
        }
        
        dto.setMenuItems(menuItemsDTO);        
        
        
        return dto;
        
    }
 
       
}

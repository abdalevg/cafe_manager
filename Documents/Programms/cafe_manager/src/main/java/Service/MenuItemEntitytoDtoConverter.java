

package Service;

import DTO.MenuItemDTO;
import Entities.MenuItem;


public class MenuItemEntitytoDtoConverter {
  
   public static MenuItem DtoToEntity(MenuItemDTO dto){
       
       MenuItem entity = new MenuItem();
       
       entity.setId(dto.getId());
       entity.setItemName(dto.getItemName());
       entity.setItemPrice(dto.getPrice());
       
       return entity;
       
   }
 
   public static MenuItemDTO  EntityToDto(MenuItem entity){
       
       MenuItemDTO dto = new MenuItemDTO();
       
       dto.setId(entity.getId());
       dto.setItemName(entity.getItemName());
       dto.setPrice(entity.getItemPrice());
              
       
       return dto;
     
   } 
     
}

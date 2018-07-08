

package Service;

import DTO.WaiterDTO;
import Entities.Waiter;


public class WaiterEntityDtoConverter {
     
    public static Waiter DtoToEntity(WaiterDTO dto){
        
        Waiter entity = new Waiter();
        
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());        
        
        return entity;
    }
    
    public static WaiterDTO  EntityToDto(Waiter entity){
        
        WaiterDTO dto = new WaiterDTO();
        
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());        
        
        return  dto;        
    }



    
    
}

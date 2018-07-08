

package DTO;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderItemDTO implements Serializable {
        
    private int id;
    private int tableNumber;
    private String orderTime;
    private int isPaid;
     
    private WaiterDTO waiter;
     
    private List<MenuItemDTO> menuItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public WaiterDTO getWaiter() {
        return waiter;
    }

    public void setWaiter(WaiterDTO waiter) {
        this.waiter = waiter;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }
     
     
     
    
}

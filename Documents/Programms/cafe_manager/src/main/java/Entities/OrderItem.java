package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="ORDER_ITEM")
@XmlRootElement
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_ORDER")
    private int id;

    @Column(name="TABLE_NUMBER")
    private int tableNumber;
    
    @Column(name="TIME_OF_ORDER")
    private String orderTime;
    
    @Column(name="IS_PAID")
    private int isPaid;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ORDER_WAITER_ID",referencedColumnName="WAITER_ID")
    private Waiter waiter;
    
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinTable(name="MENU_ITEM_ORDER",
             joinColumns = @JoinColumn(name="ID_ORDER"),
             inverseJoinColumns = @JoinColumn(name="ID_MENU_ITEM")
             )
    private List<MenuItem> menuItems;
    
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

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
        /*if(!waiter.getOrders().contains(this)){
            waiter.getOrders().add(this);
        }*/
    }

    @XmlTransient
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    
       
    
    @Override
    public String toString() {
        return "Entities.orderItem[ id=" + id + " ]";
    }
    
}



package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="MENU_ITEM")
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_MENU_ITEM")
    private int id;
    
    @Column(name="MENU_ITEM_NAME")
    private String itemName;
    
    @Column(name="MENU_PRICE")
    private int itemPrice;
    /*
    @ManyToMany
     @JoinTable(name="MENU_ITEM_ORDER",
             joinColumns = @JoinColumn(name="ID_MENU_ITEM"),
             inverseJoinColumns = @JoinColumn(name="ID_ORDER")
             )*/
    @XmlTransient
    private List<OrderItem> orderItems;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

           
    
    @Override
    public String toString() {
        return "Entities.menuItem[ id=" + id + " ]";
    }
    
}

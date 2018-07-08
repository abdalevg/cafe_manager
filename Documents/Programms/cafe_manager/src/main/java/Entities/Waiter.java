
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="WAITER")
@XmlRootElement
public class Waiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="WAITER_ID")
    private int id;
    
    @Column(name="NAME_LAST")
    private String lastName;
    
    @Column(name="NAME_FIRST")
    private String firstName;
    
    //@OneToMany(mappedBy="waiter")
    @XmlTransient
    private List<OrderItem> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /*
    public void addOrder(OrderItem order){
        this.orders.add(order);
        if(order.getWaiter()!=this){
            order.setWaiter(this);
        }
    }*/

    /*
    public List<OrderItem> getOrders() {
        return orders;
    }*/

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waiter)) {
            return false;
        }
        Waiter other = (Waiter) object;
        if ((this.id == 0 && other.id != 0) || (this.id != 0 && this.id != other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }
      
    @Override
    public String toString() {
        return "Entities.Waiter[ id=" + id + " ]";
    }
    
}

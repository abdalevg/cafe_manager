package Entities;

import Entities.MenuItem;
import Entities.Waiter;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-01T21:18:32")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Integer> isPaid;
    public static volatile SingularAttribute<OrderItem, String> orderTime;
    public static volatile ListAttribute<OrderItem, MenuItem> menuItems;
    public static volatile SingularAttribute<OrderItem, Integer> id;
    public static volatile SingularAttribute<OrderItem, Waiter> waiter;
    public static volatile SingularAttribute<OrderItem, Integer> tableNumber;

}
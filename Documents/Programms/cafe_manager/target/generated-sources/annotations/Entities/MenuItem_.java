package Entities;

import Entities.OrderItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-01T21:18:32")
@StaticMetamodel(MenuItem.class)
public class MenuItem_ { 

    public static volatile SingularAttribute<MenuItem, String> itemName;
    public static volatile SingularAttribute<MenuItem, Integer> itemPrice;
    public static volatile SingularAttribute<MenuItem, Integer> id;
    public static volatile ListAttribute<MenuItem, OrderItem> orderItems;

}
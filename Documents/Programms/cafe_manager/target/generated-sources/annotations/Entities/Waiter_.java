package Entities;

import Entities.OrderItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-01T21:18:32")
@StaticMetamodel(Waiter.class)
public class Waiter_ { 

    public static volatile SingularAttribute<Waiter, String> lastName;
    public static volatile SingularAttribute<Waiter, String> firstName;
    public static volatile ListAttribute<Waiter, OrderItem> orders;
    public static volatile SingularAttribute<Waiter, Integer> id;

}
package bookstore.dao.order;

import bookstore.dao.AbstractDao;
import bookstore.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp extends AbstractDao<Integer, Order> implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public List<Order> getOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("select b from Order b order by b.lastName", Order.class);
        return query.getResultList();
    }
}

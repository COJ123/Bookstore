package bookstore.dao.order;

import bookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();
    void saveOrder(Order order);
}

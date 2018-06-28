package bookstore.services.order;

import bookstore.entity.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    List<Order> getOrders();
}

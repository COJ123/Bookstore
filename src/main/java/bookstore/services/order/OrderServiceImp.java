package bookstore.services.order;

import bookstore.dao.order.OrderDao;
import bookstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }
}

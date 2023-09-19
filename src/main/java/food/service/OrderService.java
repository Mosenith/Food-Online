package food.service;

import food.domain.Order;
import food.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public Order getOrderById(Long orderID) {
        return orderRepository.findOrderById(orderID);
    }
}

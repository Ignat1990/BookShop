package ignatProject.service.impl;


import ignatProject.model.Order;
import ignatProject.repository.OrderRepository;
import ignatProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    protected OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        if (orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    public Optional<Order> findOrder(Long id) {
        return orderRepository.findById(id);
    }


}

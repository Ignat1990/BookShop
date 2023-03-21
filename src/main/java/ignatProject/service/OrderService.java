package ignatProject.service;


import ignatProject.model.Order;

public interface OrderService {

    void saveOrder(Order order);

    boolean deleteOrder(Long id);

}


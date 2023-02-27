package service;

import bean.Orders;


import java.util.List;

public interface OrdersService {
    public Orders saveOrder(Orders orders);

    public Orders findById(Long id);

    public List<Orders> findAllOrder();

    public void deleteOrder(Long id);

    public Orders updateOrder(Orders orders);

    public List<String> sent(Orders orders);
}
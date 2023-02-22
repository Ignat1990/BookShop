package service;

import bean.Orders;


import java.util.List;

public interface OrdersService {
    public Orders saveOrder(Orders order);

    public Orders findById(Long id);

    public List<Orders> findAllOrder();

    public void deleteOrder(Long id);

    public Orders updateOrder(Orders order);

    public List<String> sent(Orders order);
}
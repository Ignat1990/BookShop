package ignatProject.service;



import ignatProject.bean.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Orders saveOrder(Orders order);
    public Orders findById(Long id);
    public List<Orders> findAllOrder();
    public void deleteOrder(Long id);
    public Orders updateOrder(Orders order);
    public List<String> sent(Orders order);

}

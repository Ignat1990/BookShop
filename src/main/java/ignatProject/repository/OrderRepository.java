package ignatProject.repository;


import ignatProject.model.Order;
import ignatProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);


}

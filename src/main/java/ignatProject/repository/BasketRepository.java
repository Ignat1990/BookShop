package ignatProject.repository;


import ignatProject.model.Basket;
import ignatProject.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    List<Basket> findByOrder(Order order);


    List<Basket> findAllByOrderId(Long id);


}

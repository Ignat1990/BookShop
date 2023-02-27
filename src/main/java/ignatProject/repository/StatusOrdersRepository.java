package ignatProject.repository;

import ignatProject.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrdersRepository extends JpaRepository<Orders, Long> {
}

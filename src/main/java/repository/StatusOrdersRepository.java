package repository;

import bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrdersRepository extends JpaRepository<Orders,Long> {
}

package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
}

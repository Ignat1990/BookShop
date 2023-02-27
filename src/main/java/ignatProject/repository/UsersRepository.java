package ignatProject.repository;


import ignatProject.bean.Orders;
import ignatProject.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findUserByLoginAndPasswordHash(String login, String password);


    Users findUserById(int id);

    Users findByFirstName(String username);

    Users findByEmail(String email);

}





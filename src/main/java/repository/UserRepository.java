package repository;


import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer> {
    User findUserById(int id);
    User findByUsername(String username);

    User findByEmail(String email);



}

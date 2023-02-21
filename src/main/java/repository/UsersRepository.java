package repository;


import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Long> {
    User findUserById(int id);
    User findByUsername(String username);

    User findByEmail(String email);



}

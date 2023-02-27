package repository;


import bean.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public User findUserByLoginAndPassword(String login, String password);

    public User findUserByToken(String token);

    User findUserById(int id);

    User findByUsername(String username);

    User findByEmail(String email);

//
}

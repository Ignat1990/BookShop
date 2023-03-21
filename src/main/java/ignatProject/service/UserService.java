package ignatProject.service;


import ignatProject.model.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    User findUserByUsername(String username);

}

/*import ignatProject.bean.Orders;
import ignatProject.bean.Users;

import java.util.List;*/

/*
public interface UserService {
    public Users findById(Long id);
    public List<Users> findAllUsers();
    public void saveUser(Users user);
    public void deleteUser(long id);
    public Users getLogin(String login , String password);
    public Users findUser(Orders order);
    public boolean login(String token);
    public Users findUserByLoginAndPassword(String login, String password);
}*/

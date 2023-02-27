package service;

import bean.Orders;
import bean.Users;

import java.util.List;

public interface UsersService {
    public Users findById(Long id);

    public List<Users> findAllUsers();

    public void saveUser(Users user);

    public void deleteUser(long id);

    public Users getLogin(String login, String password);

    public Users findUser(Orders order);

    public boolean login(String token);

    public Users findUserByLoginAndPassword(String login, String password);
}

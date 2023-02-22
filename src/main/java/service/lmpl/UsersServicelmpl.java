package service.lmpl;

import bean.Orders;
import bean.Users;
import org.springframework.stereotype.Service;
import repository.UsersRepository;
import service.UsersService;

import java.util.List;

@Service
public class UsersServiceImpl {
    final
    UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersService findById(Long id) {
        return usersRepository.getById(id);
    }

    @Override
    public List<Users> findAllUsers() {
        return findAllUsers();
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users getLogin(String login, String password) {
        return usersRepository.findUserByLoginAndPassword(login, password);
    }
    public Users findUser(Orders orders){
        return usersRepository.getOne(orders.getIdUser());
    }
    @Override
    public boolean login(String token) {
        Users users = usersRepository.findUserByToken(token);
        return users.getLogin().equals(token);
    }
    public Users findUserByLoginAndPassword(String login, String password){
        return usersRepository.findUserByLoginAndPassword(login,password);
    }



    public boolean getUserToken(String token){
        Users user = usersRepository.findUserByToken(token);
        return user.getToken() != null;
    }
}

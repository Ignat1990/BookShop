package ignatProject.service.lmpl;

import ignatProject.bean.Orders;
import ignatProject.bean.Users;
import org.springframework.stereotype.Service;
import ignatProject.repository.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl {
    final
    UsersRepository usersRepository;

    public UsersRepository getUsersRepository() {
        return usersRepository;
    }

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }


    public Users findById(Long id) {
        return usersRepository.getById(id);
    }


    public List<Users> findAllUsers() {
        return findAllUsers();
    }


    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }


    public Users getLogin(String login, String password) {
        return (Users) usersRepository.findUserByLoginAndPasswordHash(login, password);
    }
    public Users findUser(Orders orders){
        return usersRepository.getOne(orders.getUsers().getId());
    }

   /* public boolean login(String token) {
        Users users = (Users) usersRepository.findUserByToken(token);
        return users.getLogin().equals(token);
    }*/
    public Users findUserByLoginAndPassword(String login, String password){
        return (Users) usersRepository.findUserByLoginAndPasswordHash(login,password);
    }



  /*  public boolean getUserToken(String token){
        Users users = (Users) usersRepository.findUserByToken(token);
        return users.getPasswordHash() != null;
    }*/
}

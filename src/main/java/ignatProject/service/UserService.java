package ignatProject.service;


import ignatProject.model.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    User findUserByUsername(String username);

}


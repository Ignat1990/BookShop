package service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.RolesRepository;

public class UserDetailsServiceImpl {

protected RolesRepository rolesRepository;

@Autowired
protected PasswordEncoder passwordEncoder;

/*@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    @ @ -57, 7 + 57, 7 @@public boolean deleteUser (Long userId){
        return false;*/
   /* }

    public List<Users> findAll () {
        return UsersRepository.findAll();
    }*/
}
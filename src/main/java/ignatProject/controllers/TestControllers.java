
package ignatProject.controllers;


import ignatProject.repository.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestControllers {


    public final UsersRepository usersRepository;

    public TestControllers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/admin")
    public String home() {
        System.out.println(usersRepository.findUserById(1));

        return "admin";
    }
}

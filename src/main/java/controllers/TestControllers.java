package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repository.UsersRepository;

@Controller
public class TestControllers {

    @Autowired
    public UsersRepository usersRepository;

    @GetMapping("/admin")
    public String home() {
        System.out.println(usersRepository.findUserById(1));

        return "admin";
    }
}

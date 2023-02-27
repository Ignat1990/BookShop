package ignatProject.controllers;


/*
import ignatProject.bean.Users;
import ignatProject.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UsersService userService;

    public UserController(UsersService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<Users> findUsers = userService.findAllUsers();
        model.addAttribute("users", findUsers);
        //model добавь в себя атрибут под названием юзерс(то что у нас указано на html стp,
        //и сюда положи юзера, которого получили в результате данного запроса.
        return "user-list";
        // userList путь к  html файлу
        //Model - аналог мапы, куда ложим атрибуты.
    }

    @GetMapping("/user-create")
    public String createUserForm(Users users) {
        return "user-create";
    }


    @PostMapping("/user-create")
    public String createUser(Users users) {
        userService.saveUser(users);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}*/

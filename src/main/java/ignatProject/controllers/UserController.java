package ignatProject.controllers;



import ignatProject.model.User;
import ignatProject.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserDetailsServiceImpl userDetailsServiceImpl;


    @GetMapping
    public String userhome(Model model) {
        return "user/userhome";
    }

    @GetMapping("/update")
    public String editBook(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userUpdate", user);

        return "user/updateprofile";

    }

    @PostMapping("/update")
    @Transactional
    public String updateBook(@ModelAttribute("userForm") User user) {

        System.out.println("USER=" + user);

        Long id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        userDetailsServiceImpl.updateUser(id, user);

        return "redirect:/user";
    }


}



  /*  @Autowired
    protected UsersRepository usersRepository;


    @GetMapping("/users")
    public String findAll(Model model) {
        List<Users> findUsers = usersRepository.findAll();
        model.addAttribute("users", findUsers);
        //model добавь в себя атрибут под названием юзерс(то что у нас указано на html стp,
        //и сюда положи юзера, которого получили в результате данного запроса.
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("newuser", new Users());
        return "user-create";
    }


    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("newuser") Users users, Model model) {
        usersRepository.save(users);
        return "redirect:/users";
    }*/

/*    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }*/

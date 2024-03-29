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

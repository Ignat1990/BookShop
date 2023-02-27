/*

package controllers;

import ignatProject.service.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




public class AdminController {


        private final UserDetailsService userDetailsServiceImpl;

        public AdminController(UserDetailsService userDetailsServiceImpl) {
                this.userDetailsServiceImpl = userDetailsServiceImpl;
        }


        @GetMapping("/admin")
        public String adminhome() {

                return "admin";
        }


        @GetMapping("/admin/editusers")
        public String userList(Model model) {
                model.addAttribute("allUsers", userDetailsServiceImpl.findAll());
                model.addAttribute("rolesUsers", userDetailsServiceImpl.findAll());

                return "editusers";
        }

        @GetMapping("/admin/user/delete/{id}")
        public String deleteUser(@PathVariable("id") long id) {
                userDetailsServiceImpl.delite("id");
                return "redirect:/admin/editusers";
        }
}

*/

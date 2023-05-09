
package ignatProject.controllers;

import ignatProject.model.User;
import ignatProject.repository.BasketRepository;
import ignatProject.repository.OrderRepository;
import ignatProject.repository.UserRepository;
import ignatProject.service.impl.OrderServiceImpl;
import ignatProject.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private BasketRepository basketRepository;


    @GetMapping
    public String adminHome() {

        return "admin/admin";
    }

    @GetMapping("/editusers")
    public String userList(Model model) {
        model.addAttribute("allUsers", userDetailsServiceImpl.findAll());
        model.addAttribute("roleUsers", userDetailsServiceImpl.findAll());

        return "admin/editusers";
    }

    @GetMapping("/editusers/{id}")
    public String userId(@PathVariable("id") Long id, Model model) {
        User usercard = userRepository.findById(id).get();
        model.addAttribute("usercard", usercard);
        return "admin/usercard";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDetailsServiceImpl.deleteUser(id);
        return "redirect:/admin/editusers";
    }

    @GetMapping("/orders")
    public String ordersUsers(Model model) {
        model.addAttribute("AllOrders", orderRepository.findAll());

        return "admin/adminorders/adminordersuser";
    }

    @GetMapping("/orders/view/{id}")
    public String orderId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("OrdersBooks", basketRepository.findAllByOrderId(id));

        return "admin/adminorders/bookoforder";
    }


}

/*

public class AdminController {


        private final UserDetailsService userDetailsServiceImpl;

        public AdminController(UserDetailsService userDetailsServiceImpl) {
                this.userDetailsServiceImpl = userDetailsServiceImpl;
        }


        @GetMapping("/admin")
        public String adminHome() {

                return "admin";
        }*/

/*
        @GetMapping("/admin/editusers")
        public String userList(Model model) {
                model.addAttribute("allUsers", userDetailsServiceImpl.findAll());
                model.addAttribute("rolesUsers", userDetailsServiceImpl.findAll());

                return "editusers";
        }

        @GetMapping("/admin/user/delete/{id}")
        public String deleteUser(@PathVariable("id") long id) {
                userDetailsServiceImpl.("id");
                return "redirect:/admin/editusers";
        }*/



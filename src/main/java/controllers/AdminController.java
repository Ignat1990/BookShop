package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.lmpl.UserDetailsServiceImpl;

public class AdminController {

@Autowired
private UserDetailsServiceImpl userDetailsServiceImpl;

@GetMapping("/admin")
public String adminhome () {

        return "admin";
        }

/*@GetMapping("/admin/editusers")
public String userList(Model model) {
        model.addAttribute("allUsers", userDetailsServiceImpl.findAll();
        model.addAttribute("rolesUsers", userDetailsServiceImpl.findAll();

        return "editusers";
        }

@GetMapping("/admin/user/delete/{id}")
public String deleteUser(@PathVariable("id") long id) {
        userDetailsServiceImpl.delite("id");
        return "redirect:/admin/editusers";
        }*/}
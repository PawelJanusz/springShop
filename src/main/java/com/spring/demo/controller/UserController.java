package com.spring.demo.controller;


import com.spring.demo.model.UserDao;
import com.spring.demo.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/adduser")
    public ModelAndView addUser(Model model){
        return new ModelAndView("userForm", "userToInsert", new UserDto());
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute UserDto userDto){
        userDao.saveUser(userDto);
        userDto.setAddDate(new Date());
        return "usersaveresult";
    }

    @GetMapping("/usersList")
    public String showUsers(Model model){
        List<UserDto> users = userDao.getAllUsers();
        model.addAttribute("allUsers", users);
        return "usersList";
    }
    @PostMapping("/deleteuser")
    public String deleteUser(@ModelAttribute("user") UserDto userDto ){
        userDao.deleteUser(userDto);
        return "userdeleteresult";
    }

}

package com.spring.demo.rest;

import com.spring.demo.model.UserDao;
import com.spring.demo.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<UserDto> showAllUsers(){
        return userDao.getAllUsers();
    }

    @PostMapping("/adduser")
    public UserDto addUser(@RequestBody UserDto userDto){
        userDao.saveUser(userDto);
        userDto.setAddDate(new Date());
        return userDto;
    }

//    @DeleteMapping("/deleteuser/{userId}")
//    public UserDto deleteUser(@PathVariable int userId){
//        userDao.deleteUserById(userId);
//    }





}

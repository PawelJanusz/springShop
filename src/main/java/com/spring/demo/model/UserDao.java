package com.spring.demo.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserDao {

    List<UserDto> users = new ArrayList<>();

    public void saveUser(UserDto userDto){
        users.add(userDto);
    }

    public List<UserDto> getAllUsers() {
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteUser(UserDto userDto){
        users.remove(userDto);

    }

    public void deleteUserById(int userId) {
        users.remove(userId);
    }
}

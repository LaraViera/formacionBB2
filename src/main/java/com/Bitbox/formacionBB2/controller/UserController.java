package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Users;
import com.Bitbox.formacionBB2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Boolean saveUser(@RequestBody Users u) {
        return userService.saveUser(u);
    }
}

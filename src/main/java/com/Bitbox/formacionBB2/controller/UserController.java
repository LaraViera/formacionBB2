package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Users;
import com.Bitbox.formacionBB2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/user/test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public Boolean saveUser(@RequestBody Users u) {
        return userService.saveUser(u);
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Access";
    }

}

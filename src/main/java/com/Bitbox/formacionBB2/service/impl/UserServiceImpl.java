package com.Bitbox.formacionBB2.service.impl;

import com.Bitbox.formacionBB2.model.Users;
import com.Bitbox.formacionBB2.repository.UserRepository;
import com.Bitbox.formacionBB2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean saveUser(Users user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*@Override
    public List<Users> getAllUsers() {
        List<Users> allUsers;
        try{
           allUsers= userRepository.getAllUsers();
            return allUsers;
        }catch(Exception e){
            throw e;
        }
    }*/
}

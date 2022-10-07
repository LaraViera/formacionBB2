package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    public List<Users> findByUsernameAndPassword(String userName, String password);
}

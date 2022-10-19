package com.Bitbox.formacionBB2.repository;

import com.Bitbox.formacionBB2.model.Role;
import com.Bitbox.formacionBB2.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    //public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}

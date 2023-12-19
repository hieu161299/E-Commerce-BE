package com.example.e_commerce_be.repository;

import com.example.e_commerce_be.entity.ERole;
import com.example.e_commerce_be.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}

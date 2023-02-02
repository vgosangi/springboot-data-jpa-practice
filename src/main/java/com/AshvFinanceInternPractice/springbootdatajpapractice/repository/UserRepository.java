package com.AshvFinanceInternPractice.springbootdatajpapractice.repository;

import com.AshvFinanceInternPractice.springbootdatajpapractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByNameIgnoreCase(String name);
}

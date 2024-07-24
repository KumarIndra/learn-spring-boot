package com.from28minutes.learnerAppendix.Learn_spring_boot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.from28minutes.learnerAppendix.Learn_spring_boot.User.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}

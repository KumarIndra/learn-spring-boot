package com.from28minutes.learnerAppendix.Learn_spring_boot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.from28minutes.learnerAppendix.Learn_spring_boot.User.Post;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{

}

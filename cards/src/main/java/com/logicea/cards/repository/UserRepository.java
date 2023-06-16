package com.logicea.cards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logicea.cards.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);

	//String getUsername();

}

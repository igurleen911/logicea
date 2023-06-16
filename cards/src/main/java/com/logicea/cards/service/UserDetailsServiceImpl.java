 package com.logicea.cards.service;


 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.core.userdetails.UserDetailsService;
 import org.springframework.security.core.userdetails.UsernameNotFoundException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import com.logicea.cards.entity.User;
 import com.logicea.cards.repository.UserRepository;



 @Service
 public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   UserRepository userRepository;

   @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 User user = userRepository.findByUsername(username);
     return UserDetailsImpl.build(user);
   }

 }

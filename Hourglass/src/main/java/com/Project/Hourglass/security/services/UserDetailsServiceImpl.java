package com.Project.Hourglass.security.services;

import com.Project.Hourglass.Repositories.UserRepository;
import com.Project.Hourglass.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found With -> username or email : " + username)
        );
        return UserPrinciple.build(user);
    }
}

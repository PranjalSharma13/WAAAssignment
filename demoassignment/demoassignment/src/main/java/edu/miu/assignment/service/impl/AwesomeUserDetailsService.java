package edu.miu.assignment.service.impl;


import edu.miu.assignment.entity.User;
import edu.miu.assignment.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AwesomeUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public AwesomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       var user = userRepo.findByEmail(username);
//        User user =null;
        var userDetails = new AwesomeUserDetails(user);
        return userDetails;
    }
}

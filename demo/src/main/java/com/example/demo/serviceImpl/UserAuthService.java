package com.example.demo.serviceImpl;

import com.example.demo.models.Users;
import com.example.demo.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {


    private final UserRepo userRepo;

    public UserAuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(email);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException(email);
        }
        return user;
    }
}

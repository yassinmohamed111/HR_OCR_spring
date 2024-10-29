package com.example.demo.ServiceImpl;

import com.example.demo.DTO.UserDetailsRequestDTO;
import com.example.demo.Mapper.userDetailsMapper;
import com.example.demo.Model.Users;
import com.example.demo.Model.user_details;
import com.example.demo.Service.UserDetailsService;
import com.example.demo.repository.UserDetailsRepo;
import com.example.demo.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {
    private UserDetailsRepo userDetailsRepo;
    private userDetailsMapper mapper ;
    private UserRepo  userRepo;

    public UserDetailsServiceimpl(UserDetailsRepo userDetailsRepo, UserRepo userRepo , userDetailsMapper mapper) {
        this.userDetailsRepo = userDetailsRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;

    }


    @Transactional
    @Override
    public void createUserDetails(UserDetailsRequestDTO userDetailsRequestDTO) {
        user_details userDetails  = mapper.mapperToEntity(userDetailsRequestDTO);
        userDetailsRepo.save(userDetails);
        Users user = userRepo.findByEmail(userDetailsRequestDTO.getEmail());
        user.setUser_details(userDetails);
        userRepo.save(user);
    }
}

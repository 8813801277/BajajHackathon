package com.mukul.Bajaj.Service;
import com.mukul.Bajaj.Entity.UserEntity;
import com.mukul.Bajaj.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repo.findByUsername(username);
        if(userEntity==null) throw new RuntimeException("User not found");

        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }
}

package com.mukul.Bajaj.Service;

import com.mukul.Bajaj.Entity.ActivityReq;
import com.mukul.Bajaj.Entity.UserEntity;
import com.mukul.Bajaj.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String adduser(UserEntity user){
        UserEntity exist = userRepo.findByUsername(user.getUsername());
        if(exist!=null) return "User already exist";

        long id = sequenceGeneratorService.getNext("user_sequence");
        user.setId(id);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User added successfully";
    }

    public UserEntity existByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public UserEntity dash(String username){
        return userRepo.findByUsername(username);
    }

    public void activityUp(String username, Long count, String act){
        UserEntity user = userRepo.findByUsername(username);
        if(act.equals("pushUps")){
            long prev = user.getPushUps() + count;
            user.setPushUps(prev);
        }

        else if(act.equals("squats")){
            long prev = user.getSquats() + count;
            user.setSquats(prev);
        }
        else if(act.equals("crunches")){
            long prev = user.getCrunches()+count;
            user.setCrunches(prev);
        }

        userRepo.save(user);
    }
}

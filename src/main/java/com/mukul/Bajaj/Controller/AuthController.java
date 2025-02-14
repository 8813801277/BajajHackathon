package com.mukul.Bajaj.Controller;

import com.mukul.Bajaj.Entity.ActivityReq;
import com.mukul.Bajaj.Entity.UserEntity;
import com.mukul.Bajaj.Service.AuthService;
import com.mukul.Bajaj.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public String addUser(@RequestBody UserEntity user){
        if(user.getUsername()==null || user.getPassword()==null) return "User or password cannot be null";
        return authService.adduser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
        if(user.getUsername()==null || user.getPassword()==null){
            return "User or password cannot be null";
        }
        UserEntity exists = authService.existByUsername(user.getUsername());
        if(exists!=null && passwordEncoder.matches(user.getPassword(), exists.getPassword())){
            String token = jwtUtil.generateToken(exists.getUsername());
            boolean isValid = jwtUtil.validateToken(token,exists.getUsername());
            if(!isValid) return "not validated, login again";
            return token;
        }
        return "Invalid Username or password";
    }

    @GetMapping("/dashboard")
    public UserEntity getDashboard(@RequestParam String username){
        return authService.dash(username);
    }

    @GetMapping("/upActivity")
    public void activity(@RequestParam String username, @RequestParam Long count , @RequestParam String act){
        authService.activityUp(username,count,act);
    }
}

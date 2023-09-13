package com.ufriend.controllers;

import com.ufriend.config.auth.TokenHandle;
import com.ufriend.dto.GenericOutDTO;
import com.ufriend.dto.LoginDTO;
import com.ufriend.dto.RegisterInDTO;
import com.ufriend.dto.TokenDTO;
import com.ufriend.role.RoleEntity;
import com.ufriend.user.UserDao;
import com.ufriend.user.UserEntity;
import com.ufriend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenHandle tokenHandle;

    @PostMapping("/register")
    public ResponseEntity<GenericOutDTO> register(@RequestBody RegisterInDTO registerInDTO){
        GenericOutDTO genericOutDTO = new GenericOutDTO();
        if (!registerInDTO.getPassword().equals(registerInDTO.getConfirmPassword())){
            genericOutDTO.setErrorMessage("Password and Confirm Password does not match");
            return ResponseEntity.badRequest().body(genericOutDTO);
        }
        UserEntity user = userDao.findByEmail(registerInDTO.getEmail());
        if (user != null){
            genericOutDTO.setErrorMessage("Email already taken");
            return ResponseEntity.badRequest().body(genericOutDTO);
        }
        user = new UserEntity();
        user.setEmail(registerInDTO.getEmail());
        user.setPassword(registerInDTO.getPassword());
        userService.save(user);
        genericOutDTO.setSuccessMessage("User registered!");
        return ResponseEntity.ok(genericOutDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        UserEntity user = userDao.findByEmail(loginDTO.getEmail());
        if (user == null){
            return ResponseEntity.badRequest().body("Invalid Email or Password.");
        }
        RoleEntity role = user.getRole();
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setAccessToken(tokenHandle.getAccessToken(user.getName(), role.getName()));
        tokenDTO.setRefreshToken(tokenHandle.getRefreshToken(user.getName(), role.getName()));
        return ResponseEntity.ok(tokenDTO);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok("Session closed");
    }

}

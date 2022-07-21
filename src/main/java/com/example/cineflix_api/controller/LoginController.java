package com.example.cineflix_api.controller;

import com.example.cineflix_api.helper.JwtProvider;
import com.example.cineflix_api.payload.LoginRequest;
import com.google.gson.Gson;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    // Create Logger
    Logger logger = LoggerFactory.getLogger(LoginController.class);
    // Use Gson to parse to Json
    private Gson gson = new Gson();
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        // Change info (login) of user's request to String
        String json = gson.toJson(loginRequest);
        // Log the data info of user's request in Logger
        logger.info("(IN_REQUEST) "+ json);

        // Hàm dùng để kích hoạt đăng nhập bằng tay
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName()
                        , loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtProvider.generateToken(loginRequest.getUserName());
        System.out.println("token: " +jwtToken);
        return new ResponseEntity<String>(jwtToken, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}

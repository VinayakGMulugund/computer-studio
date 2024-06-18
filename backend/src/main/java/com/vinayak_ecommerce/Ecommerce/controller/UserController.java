package com.vinayak_ecommerce.Ecommerce.controller;

import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.service.AuthService;
import com.vinayak_ecommerce.Ecommerce.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/current")
    public User getUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user, HttpServletResponse httpServletResponse) {
        if (userService.userExists(user)) {
            httpServletResponse.setStatus(403);
            return null;
        }
        httpServletResponse.setStatus(201);
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        Map<String, String> responseMap = new HashMap<>();

        if (authentication.isAuthenticated()) {
            String token = authService.generateToken(user.getEmail());
            responseMap.put("token", token);
            return ResponseEntity.ok(responseMap);
        }
        return null;
    }

}

package com.vinayak_ecommerce.Ecommerce.service;


import com.vinayak_ecommerce.Ecommerce.model.Cart;
import com.vinayak_ecommerce.Ecommerce.model.Studio;
import com.vinayak_ecommerce.Ecommerce.model.User;
import com.vinayak_ecommerce.Ecommerce.model.UserDetail;
import com.vinayak_ecommerce.Ecommerce.repository.CartRepo;
import com.vinayak_ecommerce.Ecommerce.repository.StudioRepo;
import com.vinayak_ecommerce.Ecommerce.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StudioRepo studioRepo;

    @Autowired
    private CartRepo cartRepo;

    @Getter
    private User currentUser;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }



    public User login(User user) {
        User response = userRepo.findByUsername(user.getUsername());
        if (response == null) {
            return null;
        }
        if (response.getPassword().equals(user.getPassword())) {
            return response;
        }
        return null;
    }

    //should be named "loadUserByEmail"
    // but unfortunately spring security default name for this function cannot be changed
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user==null) {
            throw new UsernameNotFoundException("User not found");
        }
        currentUser = user;
        return new UserDetail(user);
    }

    @Transactional
    public User register(User user) {

        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepo.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);

        Studio studio = new Studio();
        studio.setUser(savedUser);

        studioRepo.save(studio);
        cartRepo.save(cart);

        return savedUser;
    }

    public boolean userExists(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        return existingUser != null;
    }

    public Optional<User> getUserById(String id) {
        return userRepo.findById(Long.valueOf(id));
    }
}

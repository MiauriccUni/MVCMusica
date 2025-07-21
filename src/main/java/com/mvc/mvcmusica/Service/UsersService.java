package com.mvc.mvcmusica.Service;

import com.mvc.mvcmusica.Repository.UsersRepo;
import com.mvc.mvcmusica.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsersService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users postUsers(Users users) {
        String hashedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashedPassword);
        return usersRepo.save(users);
    }

    public Users findByEmail(String email) {
        return usersRepo.findByEmail(email);
    }

    public List<Users> findAll() {
        return usersRepo.findAll();
    }

    public Optional<Users> findById(Long id) {
        return usersRepo.findById(id);
    }

    public void deleteById(Long id) {
        usersRepo.deleteById(id);
    }

}

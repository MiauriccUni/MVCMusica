package com.mvc.mvcmusica.Controller;

import com.mvc.mvcmusica.Service.UsersService;
import com.mvc.mvcmusica.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Music/User")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    public Users save(@RequestBody Users users) {
        return usersService.postUsers(users);
    }

    @GetMapping
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Users> findById (@PathVariable("id") Long id) {
        return usersService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        try {
            findById(id);
            if (usersService.findById(id).isPresent()) {
                usersService.deleteById(id);
                return "Usuario eliminado";
            } else{
                return "Usuario no encontrado";
            }
        }catch (Exception e){
            return "Usuario no encontrado";
        }
    }
}

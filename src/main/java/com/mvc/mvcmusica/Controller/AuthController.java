package com.mvc.mvcmusica.Controller;

import com.mvc.mvcmusica.DTO.AuthRequest;
import com.mvc.mvcmusica.DTO.AuthResponse;
import com.mvc.mvcmusica.Service.JwtUtil;
import com.mvc.mvcmusica.Service.UsersService;
import com.mvc.mvcmusica.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        Users user = usersService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(user.getEmail(), user.getRol());
        return ResponseEntity.ok(new AuthResponse(token, user.getName(), user.getEmail(), user.getRol()));
    }
}

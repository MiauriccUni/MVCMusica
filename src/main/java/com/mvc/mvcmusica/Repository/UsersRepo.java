package com.mvc.mvcmusica.Repository;

import com.mvc.mvcmusica.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    public Users findByEmail(String email);
}

package com.mvc.mvcmusica.Controller;

import com.mvc.mvcmusica.Repository.SubscriptionRepo;
import com.mvc.mvcmusica.Repository.UsersRepo;
import com.mvc.mvcmusica.Service.SubscriptionService;
import com.mvc.mvcmusica.models.Subscription;
import com.mvc.mvcmusica.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Music/Subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @PostMapping
    public Subscription subscribe(@RequestBody Subscription subscription) {
        return subscriptionService.postsubs(subscription);
    }

    @PostMapping("/assign-subscription")
    public ResponseEntity<String> subUser(@RequestParam long user_id, long subscription_id) {
        Users users = usersRepo.findById(user_id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

        Subscription subscription = subscriptionRepo.findById(subscription_id)
                .orElseThrow(()-> new RuntimeException("Subscripcion no encontrada"));

        users.setSubscription(subscription);
        usersRepo.save(users);
        return ResponseEntity.ok("Subscripcion correctamente asignada");
    }

    @GetMapping
    public List<Subscription> getsubscriptions() {
        return subscriptionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Subscription> getsubscription(@PathVariable("id") Long id) {
        return subscriptionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        try {
            if(subscriptionService.findById(id).isPresent()) {
                subscriptionService.deleteById(id);
                return "Subscription eliminada correctamente";
            }
            else{
                return "Usuario no encontrado";
            }
        }
        catch (Exception e) {
            return "usuario no encontrado";
        }
    }
}

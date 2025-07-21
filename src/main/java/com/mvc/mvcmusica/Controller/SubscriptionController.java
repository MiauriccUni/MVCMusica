package com.mvc.mvcmusica.Controller;

import com.mvc.mvcmusica.Service.SubscriptionService;
import com.mvc.mvcmusica.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Music/Subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public Subscription subscribe(@RequestBody Subscription subscription) {
        return subscriptionService.postsubs(subscription);
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
    public void deleteById(@PathVariable("id") Long id) {
        subscriptionService.deleteById(id);
    }
}

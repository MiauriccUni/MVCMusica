package com.mvc.mvcmusica.Service;


import com.mvc.mvcmusica.Repository.SubscriptionRepo;
import com.mvc.mvcmusica.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SubscriptionService {

    @Autowired
    SubscriptionRepo subscriptionRepo;

    public Subscription postsubs(Subscription subscription) {
        return subscriptionRepo.save(subscription);
    }

    public List<Subscription> findAll() {
        return subscriptionRepo.findAll();
    }

    public Optional<Subscription> findById(Long id) {
        return subscriptionRepo.findById(id);
    }

    public void deleteById(Long id) {
        subscriptionRepo.deleteById(id);
    }
}

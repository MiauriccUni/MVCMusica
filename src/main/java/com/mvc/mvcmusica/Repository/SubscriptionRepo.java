package com.mvc.mvcmusica.Repository;

import com.mvc.mvcmusica.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
}

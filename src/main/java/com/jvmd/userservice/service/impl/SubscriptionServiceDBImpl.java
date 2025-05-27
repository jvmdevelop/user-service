package com.jvmd.userservice.service.impl;

import com.jvmd.userservice.exception.SubsciptionNotAdd;
import com.jvmd.userservice.model.ESubscritionType;
import com.jvmd.userservice.model.Subscription;
import com.jvmd.userservice.model.User;
import com.jvmd.userservice.payload.request.AddSubscriptionRequest;
import com.jvmd.userservice.repo.SubscriptionRepo;
import com.jvmd.userservice.repo.UserRepo;
import com.jvmd.userservice.service.SubscriptionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class SubscriptionServiceDBImpl implements SubscriptionService {

//    @Qualifier(value = "userServiceDBImpl")
    private final UserRepo userRepo;
    private final SubscriptionRepo subscriptionRepo;


    @Override
    @Transactional
    public Subscription addSubscription(Long id ,  AddSubscriptionRequest addSubscriptionRequest) {
        try {
            log.info("Add subscription to User with id: {} with params {}" , id , addSubscriptionRequest);
            User user = userRepo.findById(id).get();
            log.info("User: {}", user);
            Subscription subscription = subscriptionRepo.save(
                    Subscription.builder()
                            .type(addSubscriptionRequest.subscritionType())
                            .amount(addSubscriptionRequest.amount())
                            .expiryDate(addSubscriptionRequest.date())
                            .user(user)
                            .build()
            );
            log.info("Subscription: {}", subscription);
            user.getSubscriptions().add(subscription);
            log.info("Modified User: {}", user);

            userRepo.save(user);
            return subscription;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new SubsciptionNotAdd(e.getMessage());
        }
    }

    @Override
    public List<Subscription> getAllUserSubscriptions(Long id) {
        try {
            log.info("Get all subscriptions for User with id: {} ", id);
            User user = userRepo.findById(id).get();
            log.info("User: {}", user);
            return user.getSubscriptions();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new SubsciptionNotAdd( "User dont have subsciptions" + e.getMessage());
        }

    }

    @Override
    public void deleteSubscription(Long id) {
        try {
            Subscription subscription = subscriptionRepo.findById(id).get();
            String name = subscription.getUser().getName();
            subscriptionRepo.delete(subscription);
            log.info("Delete subscription for User: {}", name);

        }catch (Exception e){
            log.error(e.getMessage());
            throw new SubsciptionNotAdd(e.getMessage());
        }
    }
}

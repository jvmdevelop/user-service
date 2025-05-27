package com.jvmd.userservice.controller;

import com.jvmd.userservice.mapper.SubscriptionMapper;
import com.jvmd.userservice.mapper.UserMapper;
import com.jvmd.userservice.payload.request.AddSubscriptionRequest;
import com.jvmd.userservice.payload.request.UserAddRequest;
import com.jvmd.userservice.payload.request.UserUpdateRequest;
import com.jvmd.userservice.payload.response.SubscriptionInfoResponse;
import com.jvmd.userservice.payload.response.UserInfoResponse;
import com.jvmd.userservice.service.SubscriptionService;
import com.jvmd.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/public/users")
public class UserController {
    private final UserService userService;
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<UserInfoResponse> createUser(@RequestBody UserAddRequest userAddRequest) throws Exception {
        return ResponseEntity.ok(UserMapper.toUserResponse(userService.createUser(userAddRequest)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(UserMapper.toUserResponse(userService.getUserInfo(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfoResponse> updateUser(@RequestBody UserUpdateRequest request) throws Exception {
       return ResponseEntity.ok(UserMapper.toUserResponse(userService.update(request)));
    }


    @PostMapping("/{id}/subscriptions")
    public ResponseEntity<SubscriptionInfoResponse> addSubscription(@PathVariable Long id , @RequestBody AddSubscriptionRequest request) throws Exception {
        return ResponseEntity.ok(SubscriptionMapper.toResponse(subscriptionService.addSubscription( id , request)));
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionInfoResponse>> getSubscriptions(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.getAllUserSubscriptions(id).stream()
                .map(
                        (SubscriptionMapper::toResponse)
                )
                .toList()
        );
    }

    @DeleteMapping("/{id}/subscriptions")
    public ResponseEntity<Boolean> deleteSubscription(@PathVariable Long id){
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok(true);
    }

}

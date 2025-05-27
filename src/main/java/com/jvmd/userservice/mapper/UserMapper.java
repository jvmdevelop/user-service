package com.jvmd.userservice.mapper;

import com.jvmd.userservice.model.User;
import com.jvmd.userservice.payload.request.UserAddRequest;
import com.jvmd.userservice.payload.response.UserInfoResponse;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserInfoResponse toUserResponse(User user) {
        return UserInfoResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .subscriptions(user.getSubscriptions().stream()
                        .map(
                                SubscriptionMapper::toResponse
                        )
                        .collect(Collectors.toList()))
                .build();
    }

    public static User userRequestToUser(UserAddRequest userAddRequest) {
        return User.builder()
                .name(userAddRequest.username())
                .email(userAddRequest.email())
                .password(userAddRequest.password())
                .build();
    }

}

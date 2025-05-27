package com.jvmd.userservice.service.impl;

import com.jvmd.userservice.exception.UserNotSaveException;
import com.jvmd.userservice.mapper.UserMapper;
import com.jvmd.userservice.model.Subscription;
import com.jvmd.userservice.model.User;
import com.jvmd.userservice.payload.request.UserAddRequest;
import com.jvmd.userservice.payload.request.UserUpdateRequest;
import com.jvmd.userservice.repo.UserRepo;
import com.jvmd.userservice.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceDBImpl implements UserService {
    private final UserRepo repository;

    @Override
    public User createUser(UserAddRequest userAddRequest) {
        try {
            log.info("Creating user: {}", userAddRequest);
            User user = UserMapper.userRequestToUser(userAddRequest);
            user.setBalance(0.0);
            User save = repository.save(user);
            save.setSubscriptions(new ArrayList<>());
            return save;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UserNotSaveException(e.getMessage());
        }
    }

    @Override
    public User getUserInfo(Long id) {
        try {
            log.info("Retrieving userInfo with id: {}", id);
            return repository.findById(id).get();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Override
    public User update(UserUpdateRequest request) {
        User user = User.builder()
                .id(request.id())
                .password(request.password())
                .email(request.email())
                .balance(request.balance())
                .build();

        try {
            log.info("Updating user: {}", user);
            return repository.save(user);
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new UserNotSaveException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        try {
            repository.delete(getUserInfo(id));
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}

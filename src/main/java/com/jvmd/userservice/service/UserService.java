package com.jvmd.userservice.service;

import com.jvmd.userservice.model.User;
import com.jvmd.userservice.payload.request.UserAddRequest;
import com.jvmd.userservice.payload.request.UserUpdateRequest;

public interface UserService {
    User createUser(UserAddRequest userAddRequest) throws Exception;
    User getUserInfo(Long id);
    User update(UserUpdateRequest request) throws Exception;
    void deleteUser(Long id);
}

package com.greve.cavera_control.auth.service.implementation;

import com.greve.cavera_control.auth.model.User;
import com.greve.cavera_control.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByEmailOrUsername(String userInfo) {
        return null;
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Map<String, String> updatePassword(Long id, String password) {
        return Map.of();
    }

    @Override
    public Page<User> pendingApproval() {
        return null;
    }

    @Override
    public Page<User> getAll() {
        return null;
    }
}

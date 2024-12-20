package com.greve.cavera_control.auth.service;

import com.greve.cavera_control.auth.model.User;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface UserService {

    User save(User user);

    User getById(Long id);

    User getByEmailOrUsername(String userInfo);

    User update(Long id, User user);

    void delete(Long id);

    Map<String, String> updatePassword(Long id, String password);

    Page<User> pendingApproval();

    Page<User> getAll();
}

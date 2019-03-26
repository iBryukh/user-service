package com.smarthouse.user.service;

import com.smarthouse.user.entity.User;
import com.smarthouse.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<User, Long> {
    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
    }
}

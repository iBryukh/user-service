package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<User, Integer> {
    @Autowired
    public UserServiceImpl(final JpaRepository<User, Integer> repository) {
        super(repository);
    }
}

package com.smarthouse.user.service;

import com.smarthouse.commonutil.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<Role, Integer> {
    @Autowired
    public RoleServiceImpl(final JpaRepository<Role, Integer> repository) {
        super(repository);
    }
}

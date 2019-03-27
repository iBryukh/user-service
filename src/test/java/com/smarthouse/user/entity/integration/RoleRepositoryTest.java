package com.smarthouse.user.entity.integration;

import com.smarthouse.user.entity.Role;
import com.smarthouse.user.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {



    @Autowired
    private RoleRepository roleRepository;



    @Test
    public void saveTest(){
        Role user = roleRepository.save(new Role(1,"alex", 1));
        Role fromDb = roleRepository.findById((int) user.getId()).orElse(null);
        assertThat(user.getName()).isEqualTo(fromDb.getName()).isNotNull();
    }


    @Test
    public void findByIdTest() {
        Role user2 = roleRepository.save(new Role(1,"alex", 1));
        Role fromDb1 = roleRepository.findById((int) user2.getId()).orElse(null);
        assertThat(user2.getName()).isEqualTo(fromDb1.getName()).isNotNull();
    }


    @Test
    public void deleteTest(){
        Role user = roleRepository.save(new Role(6, "bar", 2));
        Role user2 = roleRepository.save(new Role(2, "bas", 2));
        roleRepository.delete(user);

        List<Role> allRoles = roleRepository.findAll();

        assertThat(allRoles).hasSize(1);
    }

    @Test
    public void deleteTestByID() {

        Role user1 = roleRepository.save(new Role(3, "bar", 2));
        Role user2 = roleRepository.save(new Role(2, "bas", 2));
        roleRepository.deleteById((int) user1.getId());

        List<Role> allRoles = roleRepository.findAll();

        assertThat(allRoles).hasSize(1);
    }

    @Test
    public void findAllTest() {
       Role alex = roleRepository.save(new Role(5, "alex", 1));
       Role ron = roleRepository.save(new Role(6, "ron", 1));

        List<Role> allRoles = roleRepository.findAll();

        assertThat(allRoles).hasSize(2).extracting(Role::getName).containsOnly(alex.getName(), ron.getName());
    }
}

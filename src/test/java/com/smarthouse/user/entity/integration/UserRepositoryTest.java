package com.smarthouse.user.entity.integration;


import com.smarthouse.user.entity.Role;
import com.smarthouse.user.entity.User;
import com.smarthouse.user.repository.RoleRepository;
import com.smarthouse.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveTest(){
        Role user1 = roleRepository.save(new Role(3, "bar", 2));
        User user = userRepository.save(new User( 1,"alex", "uhhu", "009900000", "880000077", user1));
        User fromDb = userRepository.findById(user.getId()).orElse(null);
        assertThat(user.getName()).isEqualTo(fromDb.getName()).isNotNull();
    }


    @Test
    public void findByIdTest() {
        Role user1 = roleRepository.save(new Role(3, "bar", 2));
        User user2 = userRepository.save(new User( 1,"alex", "ujju", "009000009", "80000877", user1));
        User fromDb1 = userRepository.findById(user2.getId()).orElse(null);
        assertThat(user2.getName()).isEqualTo(fromDb1.getName()).isNotNull();
    }


    @Test
    public void deleteTest(){
        Role user1 = roleRepository.save(new Role(1, "bar", 2));
        Role user4 = roleRepository.save(new Role(2, "foo", 2));
        User user = userRepository.save(new User( 6,"alex", "uhhhu", "00900009", "8870007", user1));
        User user2 = userRepository.save(new User( 2,"alex", "hhhhuu", "00000099", "80000877", user4));
        userRepository.delete(user);

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).hasSize(1);
    }

    @Test
    public void deleteTestByID() {
        Role user3 = roleRepository.save(new Role(1, "bar", 2));
        Role user4 = roleRepository.save(new Role(2, "foo", 2));
        User user1 = userRepository.save(new User( 3,"alex", "uhhhhu", "009000009", "80000877", user3));
        User user2 = userRepository.save(new User( 2,"alex", "uhhhhu", "00000099", "88000077", user4));
        userRepository.deleteById(user1.getId());

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).hasSize(1);
    }

    @Test
    public void findAllTest() {
        Role user3 = roleRepository.save(new Role(1, "bar", 2));
        Role user4 = roleRepository.save(new Role(2, "foo", 2));
        User alex = userRepository.save(new User( 5,"alex", "uuhhhh", "00900009", "88900077", user3));
        User ron = userRepository.save(new User( 6,"alex", "uuhhhh", "00900009", "89000877", user3));

        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).hasSize(2).extracting(User::getName).containsOnly(alex.getName(), ron.getName());
    }
}

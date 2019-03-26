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
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveTest(){
        Role user = roleRepository.save(new Role(1,"alex", 1));
        Role fromDb = roleRepository.findById(user.getId()).orElse(null);
        assertThat(user.getName()).isEqualTo(fromDb.getName()).isNotNull();
    }


    @Test
    public void findByIdTest() {
        Role emp = new Role(1, "alex", 1);
        entityManager.persistAndFlush(emp);

        Role fromDb = roleRepository.findById(emp.getId()).orElse(null);
        assertThat(fromDb.getName()).isEqualTo(emp.getName());
    }

    @Test
    public void deleteByIdTest() {

        Role user = roleRepository.saveAndFlush(new Role(1, "bar", 2));
        roleRepository.deleteById(user.getId());

        assertThat(user).isNull();
    }
    @Test
    public void deleteTest(){
        Role user = roleRepository.saveAndFlush(new Role(1, "bar", 2));
        roleRepository.delete(user);

        assertThat(user).isNull();
    }

    @Test
    public void findAllTest() {
       Role alex = new Role(1, "alex", 1);
       Role ron = new Role(2, "ron", 1);
       Role bob = new Role(3, "bob", 1);

        entityManager.persist(alex);
        entityManager.persist(bob);
        entityManager.persist(ron);
        entityManager.flush();

        List<Role> allRoles = roleRepository.findAll();

        assertThat(allRoles).hasSize(3).extracting(Role::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
    }
}

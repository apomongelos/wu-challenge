/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class UserRepositoryTest {
    
    public UserRepositoryTest() {
    }

    /**
     * Test of findById method, of class UserRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long userId = 0;
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        
        User expResult = user;
        User result = instance.findById(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByEmail method, of class UserRepository.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "fer@correo.com";
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        
        User expResult = user;
        User result = instance.findByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByName method, of class UserRepository.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Fernando";
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        User expResult = user;
        User result = instance.findByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class UserRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        User user1 = new User("Fernando", "fer@correo.com");
        User user2 = new User("David", "david@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user1);
        instance.save(user2);
        List<User> expResult = new ArrayList<>();
        expResult.add(user1);
        expResult.add(user2);
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class UserRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
    }

    /**
     * Test of update method, of class UserRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        
        User userUpdated = new User("David", "fer@correo.com");
        instance.update(userUpdated);
    }

    /**
     * Test of delete method, of class UserRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        instance.delete(user);
    }

    /**
     * Test of getSubscribedTopics method, of class UserRepository.
     */
    @Test
    public void testGetSubscribedTopics() {
        System.out.println("getSubscribedTopics");
        User user = new User("Fernando", "fer@correo.com");
        
        UserRepository instance = new UserRepository();
        instance.save(user);
        Topic topic1 = new Topic("Deportes");
        Topic topic2 = new Topic("Noticias");
        user.subscribeToTopic(topic1);
        user.subscribeToTopic(topic2);
        instance.update(user);
        
        List<Topic> expResult = new ArrayList<>();
        expResult.add(topic1);
        expResult.add(topic2);
        List<Topic> result = instance.getSubscribedTopics(user);
        assertEquals(expResult, result);
    }
    
}

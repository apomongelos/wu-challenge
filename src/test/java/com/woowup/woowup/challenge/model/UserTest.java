/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class UserTest {

    public UserTest() {
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User(1, "Fernando", "fer@correo.com");

        String expResult = "Fernando";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User(1, "Fernando", "fer@correo.com");

        String expResult = "fer@correo.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserId method, of class User.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        User instance = new User(1, "Fernando", "fer@correo.com");

        long expResult = 1;
        long result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        User instance = new User(1, "Fernando", "fer@correo.com");

        String name = "David";
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        User instance = new User(1, "Fernando", "fer@correo.com");

        String email = "david@correo.com";
        instance.setEmail(email);
        String result = instance.getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of setUserId method, of class User.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");

        User instance = new User(1, "Fernando", "fer@correo.com");
        long userId = 2;
        instance.setUserId(userId);
        long result = instance.getUserId();
        assertEquals(userId, result);
    }

    /**
     * Test of getReceivedAlerts method, of class User.
     */
    @Test
    public void testGetReceivedAlerts() throws ParseException {
        System.out.println("getReceivedAlerts");
        User instance = new User(1, "Fernando", "fer@correo.com");

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("new footbal game", dateTest, true, topic, true);
        instance.addAlert(alert);

        List<Alert> expResult = new ArrayList<>();
        expResult.add(alert);
        List<Alert> result = instance.getReceivedAlerts();
        assertEquals(expResult, result);
    }

    /**
     * Test of addAlert method, of class User.
     */
    @Test
    public void testAddAlert() throws ParseException {
        System.out.println("addAlert");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert alert = new Alert("new footbal game", dateTest, true, topic, true);
        User instance = new User(1, "Fernando", "fer@correo.com");
        instance.addAlert(alert);
    }

    /**
     * Test of getReadedAlerts method, of class User.
     */
    @Test
    public void testGetReadedAlerts() throws ParseException {
        System.out.println("getReadedAlerts");
        User instance = new User(1, "Fernando", "fer@correo.com");

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("new footbal game", dateTest, true, topic, true);
        instance.addAlert(alert);
        instance.markAlertAsRead(alert);

        List<Alert> expResult = new ArrayList<>();
        expResult.add(alert);
        List<Alert> result = instance.getReadedAlerts();
        assertEquals(expResult, result);
    }

    /**
     * Test of markAlertAsRead method, of class User.
     */
    @Test
    public void testMarkAlertAsRead() throws ParseException {
        System.out.println("markAlertAsRead");
        User instance = new User(1, "Fernando", "fer@correo.com");

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("new footbal game", dateTest, true, topic, true);
        instance.addAlert(alert);
        instance.markAlertAsRead(alert);
    }

    /**
     * Test of subscribeToTopic method, of class User.
     */
    @Test
    public void testSubscribeToTopic() {
        System.out.println("subscribeToTopic");
        User instance = new User(1, "Fernando", "fer@correo.com");
        Topic topic = new Topic(1, "Deportes");
        instance.subscribeToTopic(topic);
    }

    /**
     * Test of getSubscribedTopics method, of class User.
     */
    @Test
    public void testGetSubscribedTopics() {
        System.out.println("getSubscribedTopics");
        User instance = new User(1, "Fernando", "fer@correo.com");
        
        Topic topic = new Topic(1, "Deportes");
        instance.subscribeToTopic(topic);
        List<Topic> expResult = new ArrayList<>();
        expResult.add(topic);
        List<Topic> result = instance.getSubscribedTopics(instance);
        assertEquals(expResult, result);
    }

}

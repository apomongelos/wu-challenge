/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.controller;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import com.woowup.woowup.challenge.repository.AlertRepository;
import com.woowup.woowup.challenge.repository.TopicRepository;
import com.woowup.woowup.challenge.repository.UserRepository;
import com.woowup.woowup.challenge.service.AlertService;
import com.woowup.woowup.challenge.service.AlertServiceImpl;
import com.woowup.woowup.challenge.service.TopicService;
import com.woowup.woowup.challenge.service.TopicServiceImpl;
import com.woowup.woowup.challenge.service.UserService;
import com.woowup.woowup.challenge.service.UserServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AlertControllerTest {

    public AlertControllerTest() {
    }

    /**
     * Test of addAlert method, of class AlertController.
     */
    @Test
    public void testAddAlert() throws ParseException {
        System.out.println("addAlert");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);

        Alert result = instance.addAlert("prueba", dateTest, true, topic, true);
        Alert expResult = instance.getAlert(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of sendAlert method, of class AlertController.
     */
    @Test
    public void testSendAlert() throws ParseException {
        System.out.println("sendAlert");

        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = instance.addAlert("prueba", dateTest, true, topic, true);
        instance.sendAlert(alert);
    }

    /**
     * Test of sendSpecificAlert method, of class AlertController.
     */
    @Test
    public void testSendSpecificAlert() throws ParseException {
        System.out.println("sendSpecificAlert");
        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert alert = instance.addAlert("prueba", dateTest, true, topic, true);
        User user = userService.addUser("Fernando", "fer@correo.com");
        instance.sendSpecificAlert(alert, user);
    }

    /**
     * Test of getAllAlerts method, of class AlertController.
     */
    @Test
    public void testGetAllAlerts() throws ParseException {
        System.out.println("getAllAlerts");
        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = instance.addAlert("prueba", dateTest, true, topic, true);

        Date dateTest2 = DateFor.parse("02/01/2023");
        Alert alert2 = instance.addAlert("prueba2", dateTest2, true, topic, true);

        List<Alert> expResult = new ArrayList<>();
        expResult.add(instance.getAlert(0));
        expResult.add(instance.getAlert(1));
        List<Alert> result = instance.getAllAlerts();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnexpiredAndUnreadAlertsByUser method, of class
     * AlertController.
     */
    @Test
    public void testGetUnexpiredAndUnreadAlertsByUser() throws ParseException {
        System.out.println("getUnexpiredAndUnreadAlertsByUser");
        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);
        User user = userService.addUser("Fernando", "fer@correo.com");

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = instance.addAlert("prueba", dateTest, true, topic, true);

        userService.addAlertToUser(0, alert);

        List<Alert> expResult = new ArrayList<>();
        expResult.add(instance.getAlert(0));
        List<Alert> result = instance.getUnexpiredAndUnreadAlertsByUser(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnexpiredAndUnreadAlertsByTopic method, of class
     * AlertController.
     */
    @Test
    public void testGetUnexpiredAndUnreadAlertsByTopic() throws ParseException {
        System.out.println("getUnexpiredAndUnreadAlertsByTopic");
        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository userRepo = new UserRepository();

        AlertService alertService = new AlertServiceImpl(alertRepo);
        TopicService topicService = new TopicServiceImpl(topicRepo);
        UserService userService = new UserServiceImpl(userRepo);

        AlertController instance = new AlertController(alertService, topicService, userService);
        Topic topic = topicService.addTopic("Deportes");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Alert alert = instance.addAlert("prueba", dateTest, true, topic, true);

        List<Alert> expResult = new ArrayList<>();
        expResult.add(instance.getAlert(0));
        List<Alert> result = instance.getUnexpiredAndUnreadAlertsByTopic(topic);
        assertEquals(expResult, result);
    }

}

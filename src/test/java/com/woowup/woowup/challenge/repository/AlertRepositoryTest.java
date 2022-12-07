/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
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
public class AlertRepositoryTest {
    
    public AlertRepositoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findById method, of class AlertRepository.
     */
    @Test
    public void testFindById() throws ParseException {
        System.out.println("findById");
        long alertId = 0;
        
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert newAlert = new Alert("prueba", dateTest, true, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(newAlert);
        
        Alert expResult = newAlert;
        expResult.setAlertId(alertId);
        Alert result = instance.findById(alertId);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByMessage method, of class AlertRepository.
     */
    @Test
    public void testFindByMessage() throws ParseException {
        System.out.println("findByMessage");
        String message = "prueba";
        
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert newAlert = new Alert("prueba", dateTest, true, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(newAlert);
        
        Alert expResult = newAlert;
        expResult.setAlertId(0);
        Alert result = instance.findByMessage(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class AlertRepository.
     */
    @Test
    public void testFindAll() throws ParseException {
        System.out.println("findAll");
        
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert newAlert = new Alert("prueba", dateTest, true, topic, true);
        Date dateTest2 = DateFor.parse("02/01/2023");
        Alert newAlert2 = new Alert("prueba", dateTest2, false, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(newAlert);
        instance.save(newAlert2);
        
        List<Alert> expResult = new ArrayList<>();
        expResult.add(newAlert);
        expResult.add(newAlert2);
        List<Alert> result = instance.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class AlertRepository.
     */
    @Test
    public void testSave() throws ParseException {
        System.out.println("save");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("prueba", dateTest, true, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(alert);
    }

    /**
     * Test of update method, of class AlertRepository.
     */
    @Test
    public void testUpdate() throws ParseException {
        System.out.println("update");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("prueba", dateTest, true, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(alert);
        
        Alert alertUpdated = new Alert("prueba 2", dateTest, false, topic, true);
        instance.update(alertUpdated);
    }

    /**
     * Test of delete method, of class AlertRepository.
     */
    @Test
    public void testDelete() throws ParseException {
        System.out.println("delete");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");
        Alert alert = new Alert("prueba", dateTest, true, topic, true);
        
        AlertRepository instance = new AlertRepository();
        instance.save(alert);
        instance.delete(alert);
    }
    
}

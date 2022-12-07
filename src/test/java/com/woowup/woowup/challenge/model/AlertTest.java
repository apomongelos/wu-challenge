/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class AlertTest {

    public AlertTest() {
    }

    /**
     * Test of getMessage method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testGetMessage() throws ParseException {
        System.out.println("getMessage");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        String expResult = "prueba";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExpirationDate method, of class Alert.
     */
    @Test
    public void testGetExpirationDate() throws ParseException {
        System.out.println("getExpirationDate");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        Date expResult = DateFor.parse("08/07/2023");
        Date result = instance.getExpirationDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUrgent method, of class Alert.
     */
    @Test
    public void testIsUrgent() throws ParseException {
        System.out.println("isUrgent");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        boolean expResult = true;
        boolean result = instance.isUrgent();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSpecific method, of class Alert.
     */
    @Test
    public void testIsSpecific() throws ParseException {
        System.out.println("isSpecific");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        boolean expResult = true;
        boolean result = instance.isSpecific();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTopic method, of class Alert.
     */
    @Test
    public void testGetTopic() throws ParseException {
        System.out.println("getTopic");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        Topic expResult = topic;
        Topic result = instance.getTopic();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAlertId method, of class Alert.
     */
    @Test
    public void testGetAlertId() throws ParseException {
        System.out.println("getAlertId");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        long expResult = 1;
        long result = instance.getAlertId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetMessage() throws ParseException {
        System.out.println("setMessage");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        String message = "prueba";
        instance.setMessage(message);
        String result = instance.getMessage();
        assertEquals(message, result);

    }

    /**
     * Test of setExpirationDate method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetExpirationDate() throws ParseException {
        System.out.println("setExpirationDate");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        Date expirationDate = DateFor.parse("08/07/2023");
        instance.setExpirationDate(expirationDate);
        Date result = instance.getExpirationDate();
        assertEquals(expirationDate, result);
    }

    /**
     * Test of setIsUrgent method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetIsUrgent() throws ParseException {
        System.out.println("setIsUrgent");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        boolean isUrgent = false;
        instance.setIsUrgent(isUrgent);
        boolean result = instance.isUrgent();
        assertEquals(isUrgent, result);
    }

    /**
     * Test of setTopic method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetTopic() throws ParseException {
        System.out.println("setTopic");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        Topic topic2 = new Topic(2, "Noticias");
        instance.setTopic(topic2);
        Topic result = instance.getTopic();
        assertEquals(topic2, result);
    }

    /**
     * Test of setAlertId method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetAlertId() throws ParseException {
        System.out.println("setAlertId");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        long alertId = 2;
        instance.setAlertId(alertId);
        long result = instance.getAlertId();
        assertEquals(alertId, result);

    }

    /**
     * Test of setIsSpecific method, of class Alert.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testSetIsSpecific() throws ParseException {
        System.out.println("setIsSpecific");
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date dateTest = DateFor.parse("08/07/2023");
        Topic topic = new Topic(1, "Deportes");

        Alert instance = new Alert(1, "prueba", dateTest, true, topic, true);
        boolean isSpecific = false;
        instance.setIsSpecific(isSpecific);
        boolean result = instance.isSpecific();
        assertEquals(isSpecific, result);
    }

}

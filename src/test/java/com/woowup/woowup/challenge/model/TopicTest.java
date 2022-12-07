/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Usuario
 */
public class TopicTest {

    public TopicTest() {
    }

    /**
     * Test of getName method, of class Topic.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Topic instance = new Topic(1, "Deportes");

        String expResult = "Deportes";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTopicId method, of class Topic.
     */
    @Test
    public void testGetTopicId() {
        System.out.println("getTopicId");
        Topic instance = new Topic(1, "Deportes");

        long expResult = 1;
        long result = instance.getTopicId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Topic.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        Topic instance = new Topic(1, "Deportes");
        String name = "Noticias";
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of setTopicId method, of class Topic.
     */
    @Test
    public void testSetTopicId() {
        System.out.println("setTopicId");
        Topic instance = new Topic(1, "Deportes");

        long topicId = 2;
        instance.setTopicId(topicId);
        Long result = instance.getTopicId();
        assertEquals(topicId, result);
    }

}

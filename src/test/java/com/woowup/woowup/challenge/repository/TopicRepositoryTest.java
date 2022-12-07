/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Topic;
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
public class TopicRepositoryTest {

    public TopicRepositoryTest() {
    }

    /**
     * Test of findById method, of class TopicRepository.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long topicId = 0;

        Topic topic = new Topic("Deportes");

        TopicRepository instance = new TopicRepository();
        instance.save(topic);

        Topic expResult = topic;
        expResult.setTopicId(topicId);

        Topic result = instance.findById(topicId);
        assertEquals(expResult, result);
    }

    /**
     * Test of findByName method, of class TopicRepository.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Deportes";
        Topic topic = new Topic("Deportes");

        TopicRepository instance = new TopicRepository();
        instance.save(topic);

        Topic expResult = topic;
        expResult.setTopicId(0);

        Topic result = instance.findByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class TopicRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Topic topic1 = new Topic("Deportes");
        Topic topic2 = new Topic("Noticas");

        TopicRepository instance = new TopicRepository();
        instance.save(topic1);
        instance.save(topic2);

        List<Topic> expResult = new ArrayList<>();
        expResult.add(topic1);
        expResult.add(topic2);
        List<Topic> result = instance.findAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class TopicRepository.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Topic topic = new Topic("Deportes");

        TopicRepository instance = new TopicRepository();
        instance.save(topic);
    }

    /**
     * Test of update method, of class TopicRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Topic topic = new Topic("Deportes");

        TopicRepository instance = new TopicRepository();
        instance.save(topic);

        Topic topicUpdated = new Topic("Noticias");
        instance.update(topicUpdated);
    }

    /**
     * Test of delete method, of class TopicRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Topic topic = new Topic("Deportes");

        TopicRepository instance = new TopicRepository();
        instance.save(topic);
        instance.delete(topic);
    }

}

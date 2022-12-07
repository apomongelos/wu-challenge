/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.service;

import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.repository.TopicRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TopicService {

    // Métodos de la clase
    public Topic addTopic(String name);

    public void updateTopic(long topicId, String name);

    public void deleteTopic(long topicId);

    public List<Topic> getAllTopics();

    public Topic getTopicById(long topicId);

    public Topic getTopicByName(String name);
}

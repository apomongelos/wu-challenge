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
public class TopicServiceImpl implements TopicService {

    // Atributo que almacena una instancia de la clase TopicRepository
    private final TopicRepository topicRepository;

    // Constructor de la clase
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // Métodos de la clase
    @Override
    public Topic addTopic(String name) {
        Topic newTopic = new Topic(name);
        this.topicRepository.save(newTopic);
        return newTopic;
    }

    @Override
    public void updateTopic(long topicId, String name) {
        Topic topicToUpdate = this.topicRepository.findById(topicId);
        topicToUpdate.setName(name);
        this.topicRepository.update(topicToUpdate);
    }

    @Override
    public void deleteTopic(long topicId) {
        Topic topicToDelete = this.topicRepository.findById(topicId);
        this.topicRepository.delete(topicToDelete);
    }

    @Override
    public List<Topic> getAllTopics() {
        return this.topicRepository.findAll();
    }

    @Override
    public Topic getTopicById(long topicId) {
        return this.topicRepository.findById(topicId);
    }

    @Override
    public Topic getTopicByName(String name) {
        return this.topicRepository.findByName(name);
    }
}

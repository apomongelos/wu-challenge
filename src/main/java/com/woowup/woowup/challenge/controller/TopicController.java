/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.controller;

import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.service.TopicService;

/**
 *
 * @author Usuario
 */
public class TopicController {

    // Atributo que almacena una instancia de la clase TopicService
    private final TopicService topicService;

    // Constructor de la clase
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    // Métodos de la clase
    public Topic addTopic(String name) {
        return this.topicService.addTopic(name);
    }

    public Topic getTopicById(long topicId) {
        return this.topicService.getTopicById(topicId);
    }

    public Topic getTopicByName(String name) {
        return this.topicService.getTopicByName(name);
    }
}

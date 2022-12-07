/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Topic;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TopicRepository {

    // Atributo que almacena la lista de topicos en el sistema
    private List<Topic> topics;

    // Atributo que lleva el conteo de los topicos agregados al sistema
    private long topicCounter = 0;

    public TopicRepository() {
        this.topics = new ArrayList<>();
    }

    public Topic findById(long topicId) {
        return this.topics.stream()
                .filter(topic -> topic.getTopicId() == topicId)
                .findFirst()
                .orElse(null);
    }

    public Topic findByName(String name) {
        for (Topic topic : topics) {
            if (topic.getName().equals(name)) {
                return topic;
            }
        }
        return null;
    }

    public List<Topic> findAll() {
        return topics;
    }

    public void save(Topic topic) {
        // Asignamos el identificador único del usuario utilizando el contador
        topic.setTopicId(this.topicCounter);
        // Incrementamos el contador para el próximo usuario
        this.topicCounter++;
        this.topics.add(topic);
    }

    public void update(Topic topic) {
        int index = topics.indexOf(topic);
        if (index != -1) {
            topics.set(index, topic);
        }
    }

    public void delete(Topic topic) {
        topics.remove(topic);
    }
}

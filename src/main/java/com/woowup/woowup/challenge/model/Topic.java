/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

/**
 *
 * @author Usuario
 */
public class Topic {

    // Atributos de la clase
    private long topicId;
    private String name;

    // Constructor de la clase
    public Topic(long topicId, String name) {
        this.topicId = topicId;
        this.name = name;
    }

    public Topic(String name) {
        this.topicId = 0;
        this.name = name;
    }

    // Métodos de la clase
    public String getName() {
        return name;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }
}

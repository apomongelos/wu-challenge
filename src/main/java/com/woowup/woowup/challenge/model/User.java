/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class User {

    // Atributos de la clase
    private long userId;
    private String name;
    private String email;
    private List<Alert> receivedAlerts; // Atributo que almacena las alertas recibidas por el usuario
    private List<Alert> readedAlerts; // Atributo que almacena las alertas leidas por el usuario
    private List<Topic> subscribedTopics; // Atributo que almacena los temas a los que está suscrito el usuario

    // Constructor de la clase
    public User(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.receivedAlerts = new ArrayList<>();
        this.readedAlerts = new ArrayList<>();
        this.subscribedTopics = new ArrayList<>();
    }

    public User(String name, String email) {
        this.userId = 0;
        this.name = name;
        this.email = email;
        this.receivedAlerts = new ArrayList<>();
        this.readedAlerts = new ArrayList<>();
        this.subscribedTopics = new ArrayList<>();
    }

    // Métodos de la clase
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    // Método que devuelve la lista de alertas recibidas por el usuario
    public List<Alert> getReceivedAlerts() {
        return this.receivedAlerts;
    }

    // Método que permite agregar una alerta al usuario
    public void addAlert(Alert alert) {
        this.receivedAlerts.add(alert);
    }

    // Método que devuelve la lista de alertas leidas por el usuario
    public List<Alert> getReadedAlerts() {
        return this.readedAlerts;
    }

    // Método que permite marcar una alerta como leída
    public void markAlertAsRead(Alert alert) {
        this.receivedAlerts.remove(alert);
        this.readedAlerts.add(alert);
    }

    // Método que permite a un usuario suscribirse a un tema
    public void subscribeToTopic(Topic topic) {
        this.subscribedTopics.add(topic);
    }

    // Método que devuelve la lista de temas a los que está suscrito el usuario
    public List<Topic> getSubscribedTopics(User user) {
        return this.subscribedTopics;
    }
}

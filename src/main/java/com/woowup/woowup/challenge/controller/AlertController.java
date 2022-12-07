/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.controller;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import com.woowup.woowup.challenge.service.AlertService;
import com.woowup.woowup.challenge.service.TopicService;
import com.woowup.woowup.challenge.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AlertController {

    // Atributo que almacena una instancia de la clase AlertService
    private final AlertService alertService;
    private final TopicService topicService;
    private final UserService userService;

    // Constructor de la clase
    public AlertController(AlertService alertService, TopicService topicService, UserService userService) {
        this.alertService = alertService;
        this.topicService = topicService;
        this.userService = userService;
    }

    // Métodos de la clase
    public Alert addAlert(String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific) {
        return this.alertService.addAlert(message, expirationDate, isUrgent, topic, isSpecific);
    }

    // sendAlertToSubscribedUsers
    public void sendAlert(Alert alert) {
        // Envía la alerta a todos los usuarios suscritos al tema de la alerta o que la alerta sea urgente
        for (User user : this.userService.getAllUsers()) {
            if (this.userService.getSubscribedTopicsByUser(user).contains(alert.getTopic()) || alert.isUrgent()) {
                this.userService.addAlertToUser(user.getUserId(), alert);
                System.out.println("Enviando alerta a " + user.getName() + ": " + alert.getMessage() + ", es urgente: " + alert.isUrgent());
            }
        }
    }

    // sendAlertToUser
    public void sendSpecificAlert(Alert alert, User user) {
        // Envía la alerta específica al usuario especificado
        if (this.userService.getAllUsers().contains(user)) {
            this.userService.addAlertToUser(user.getUserId(), alert);
        }
    }

    public List<Alert> getAllAlerts() {
        return this.alertService.getAllAlerts();
    }

    public Alert getAlert(long alertId) {
        return this.alertService.getAlert(alertId);
    }

    // Método que devuelve las alertas no expiradas y no leídas de un usuario, ordenadas por fecha de la más reciente a la más antigua
    public List<Alert> getUnexpiredAndUnreadAlertsByUser(User user) {
        // Crea una lista vacía para almacenar las alertas
        List<Alert> unexpiredAndUnreadAlertsByUser = new ArrayList<>();

        // Obtiene la fecha actual
        Date currentDate = new Date();

        // Recorre la lista de alertas recibidas por el usuario
        for (Alert alert : user.getReceivedAlerts()) {
            // Si la alerta no ha expirado y no ha sido leída, se agrega a la lista
            if (currentDate.before(alert.getExpirationDate()) && !user.getReadedAlerts().contains(alert)) {
                unexpiredAndUnreadAlertsByUser.add(alert);
            }
        }

        // Ordena la lista por fecha de la más reciente a la más antigua
        unexpiredAndUnreadAlertsByUser.sort((a1, a2) -> a2.getExpirationDate().compareTo(a1.getExpirationDate()));

        return unexpiredAndUnreadAlertsByUser;
    }

    // Método que devuelve las alertas no expiradas de un tema (de la más reciente a la más antigua). 
    // Se muestra para cada alerta si es para todos los usuarios o para uno específico.
    public List<Alert> getUnexpiredAndUnreadAlertsByTopic(Topic topic) {
        // Crea una lista vacía para almacenar las alertas
        List<Alert> unexpiredAndUnreadAlertsByTopic = new ArrayList<>();

        // Obtiene la fecha actual
        Date currentDate = new Date();

        // Recorre la lista de alertas
        for (Alert alert : this.alertService.getAllAlerts()) {
            // Si la alerta pertenece al tema y no ha expirado, se agrega a la lista
            if (alert.getTopic().equals(topic) && currentDate.before(alert.getExpirationDate())) {
                unexpiredAndUnreadAlertsByTopic.add(alert);
            }
        }

        // Ordena la lista por fecha de la más reciente a la más antigua
        unexpiredAndUnreadAlertsByTopic.sort((a1, a2) -> a2.getExpirationDate().compareTo(a1.getExpirationDate()));

        return unexpiredAndUnreadAlertsByTopic;
    }
}

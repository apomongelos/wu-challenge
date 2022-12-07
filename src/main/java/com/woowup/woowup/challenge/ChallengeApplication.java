/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge;

import com.woowup.woowup.challenge.controller.AlertController;
import com.woowup.woowup.challenge.controller.TopicController;
import com.woowup.woowup.challenge.controller.UserController;
import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import com.woowup.woowup.challenge.repository.AlertRepository;
import com.woowup.woowup.challenge.repository.TopicRepository;
import com.woowup.woowup.challenge.repository.UserRepository;
import com.woowup.woowup.challenge.service.AlertServiceImpl;
import com.woowup.woowup.challenge.service.TopicServiceImpl;
import com.woowup.woowup.challenge.service.UserServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ChallengeApplication {

    public static void main(String[] args) throws ParseException {
        AlertRepository alertRepo = new AlertRepository();
        TopicRepository topicRepo = new TopicRepository();
        UserRepository usrRepo = new UserRepository();

        AlertServiceImpl alertService = new AlertServiceImpl(alertRepo);
        TopicServiceImpl topicService = new TopicServiceImpl(topicRepo);
        UserServiceImpl usrService = new UserServiceImpl(usrRepo);

        UserController usrController = new UserController(usrService);
        AlertController alertSystem = new AlertController(alertService, topicService, usrService);
        TopicController topicController = new TopicController(topicService);

        Topic topicMeteorologico = topicController.addTopic("Servicio metereologico");
        Topic topicDeportes = topicController.addTopic("Deportes");

        User rodri = usrController.addUser("Rodrigo", "rodri@correo.com");
        User sebas = usrController.addUser("Sebastian", "sebas@correo.com");
        usrController.addTopicToUser(rodri.getUserId(), topicDeportes);
//        usrController.addTopicToUser(sebas.getUserId(), topicDeportes);
        usrController.addTopicToUser(rodri.getUserId(), topicMeteorologico);

        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = DateFor.parse("08/07/2023");
        Date date2 = DateFor.parse("12/02/2022");

        Alert alertaPartidoSemis1 = alertSystem.addAlert("nuevo partido semis 1", date1, false, topicDeportes, false);
        Alert alertaPartidoSemis2 = alertSystem.addAlert("nuevo partido semis 2", date2, true, topicDeportes, false);

        alertSystem.sendAlert(alertaPartidoSemis1);
        alertSystem.sendAlert(alertaPartidoSemis2);

        for (Alert alert : alertSystem.getUnexpiredAndUnreadAlertsByTopic(topicDeportes)) {
            System.out.println("Alerta: " + alert.getMessage() + ", con fecha caducidad " + alert.getExpirationDate() + ", es para usario especifico: " + alert.isSpecific());
        }
        for (Alert alert : alertSystem.getUnexpiredAndUnreadAlertsByUser(sebas)) {
            System.out.println("Antes de marcar como leido");
            System.out.println("Alerta: " + alert.getMessage() + ", con fecha caducidad " + alert.getExpirationDate());
        }
//
//        usrController.markAlertAsRead(sebas.getUserId(), alertaPartidoSemis2);
//
//        for (Alert alert : alertSystem.getUnexpiredAndUnreadAlertsByUser(sebas)) {
//            System.out.println("Despues de marcar como leido");
//            System.out.println("Alerta: " + alert.getMessage() + ", con fecha caducidad " + alert.getExpirationDate());
//        }
    }
}

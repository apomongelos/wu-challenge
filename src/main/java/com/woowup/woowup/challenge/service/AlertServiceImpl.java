/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.service;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.repository.AlertRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AlertServiceImpl implements AlertService {

    // Atributo que almacena una instancia de la clase AlertRepository
    private final AlertRepository alertRepository;

    // Constructor de la clase
    public AlertServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    // Métodos de la clase
    @Override
    public Alert addAlert(String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific) {
        Alert alert = new Alert(message, expirationDate, isUrgent, topic, isSpecific);
        this.alertRepository.save(alert);
        return alert;
    }

    @Override
    public void updateAlert(long alertId, String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific) {
        Alert alertToUpdate = this.alertRepository.findById(alertId);
        alertToUpdate.setMessage(message);
        alertToUpdate.setExpirationDate(expirationDate);
        alertToUpdate.setIsUrgent(isUrgent);
        alertToUpdate.setTopic(topic);
        this.alertRepository.update(alertToUpdate);
    }

    @Override
    public void deleteAlert(long alertId) {
        Alert alertToDelete = this.alertRepository.findById(alertId);
        this.alertRepository.delete(alertToDelete);
    }

    @Override
    public List<Alert> getAllAlerts() {
        return this.alertRepository.findAll();
    }

    @Override
    public Alert getAlert(long alertId) {
        return this.alertRepository.findById(alertId);
    }
}

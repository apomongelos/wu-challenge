/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Alert;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AlertRepository {

    private List<Alert> alerts;

    // Atributo que lleva el conteo de los topicos agregados al sistema
    private long alertCounter = 0;

    public AlertRepository() {
        this.alerts = new ArrayList<>();
    }

    public Alert findById(long alertId) {
        return this.alerts.stream()
                .filter(alert -> alert.getAlertId() == alertId)
                .findFirst()
                .orElse(null);
    }

    public Alert findByMessage(String message) {
        for (Alert alert : alerts) {
            if (alert.getMessage().equals(message)) {
                return alert;
            }
        }
        return null;
    }

    public List<Alert> findAll() {
        return alerts;
    }

    public void save(Alert alert) {
        // Asignamos el identificador único del usuario utilizando el contador
        alert.setAlertId(this.alertCounter);
        // Incrementamos el contador para el próximo usuario
        this.alertCounter++;
        this.alerts.add(alert);
    }

    public void update(Alert alert) {
        int index = alerts.indexOf(alert);
        if (index != -1) {
            alerts.set(index, alert);
        }
    }

    public void delete(Alert alert) {
        alerts.remove(alert);
    }
}

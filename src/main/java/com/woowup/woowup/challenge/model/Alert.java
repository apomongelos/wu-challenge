/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.model;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Alert {

    // Atributos de la clase
    private long alertId;
    private String message;
    private Date expirationDate;
    private boolean isUrgent;
    private Topic topic; // Atributo que almacena el topico al que pertenece la alerta
    private boolean isSpecific; // Nuevo atributo que indica si la alerta es específica para un usuario o no

    // Constructor de la clase
    public Alert(long alertId, String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific) {
        this.alertId = alertId;
        this.message = message;
        this.expirationDate = expirationDate;
        this.isUrgent = isUrgent;
        this.topic = topic;
        this.isSpecific = isSpecific;
    }

    public Alert(String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific) {
        this.alertId = 0;
        this.message = message;
        this.expirationDate = expirationDate;
        this.isUrgent = isUrgent;
        this.topic = topic;
        this.isSpecific = isSpecific;
    }

    // Métodos de la clase
    public String getMessage() {
        return message;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public boolean isSpecific() {
        return isSpecific;
    }

    public Topic getTopic() {
        return topic;
    }

    public long getAlertId() {
        return alertId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

    public void setIsSpecific(boolean isSpecific) {
        this.isSpecific = isSpecific;
    }

}

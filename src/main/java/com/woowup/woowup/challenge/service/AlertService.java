/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.service;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface AlertService {

    public Alert addAlert(String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific);

    public void updateAlert(long alertId, String message, Date expirationDate, boolean isUrgent, Topic topic, boolean isSpecific);

    public void deleteAlert(long alertId);

    public List<Alert> getAllAlerts();
    
    public Alert getAlert(long alertId);
}

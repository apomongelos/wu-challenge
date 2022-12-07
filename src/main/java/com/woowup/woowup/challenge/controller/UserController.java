/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.controller;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import com.woowup.woowup.challenge.service.UserService;

/**
 *
 * @author Usuario
 */
public class UserController {

    // Atributo que almacena una instancia de la clase AlertService    
    private final UserService userService;

    // Constructor de la clase
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Métodos de la clase
    public User addUser(String name, String email) {
        return this.userService.addUser(name, email);
    }

    public void addTopicToUser(long userId, Topic topic) {
        this.userService.addTopicToUser(userId, topic);
    }

    public void markAlertAsRead(long userId, Alert alert) {
        this.userService.markAlertAsRead(userId, alert);
    }
}

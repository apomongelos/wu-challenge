/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.service;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface UserService {

    // Métodos de la clase
    public User addUser(String name, String email);

    public void updateUser(long userId, String name, String email);

    public void deleteUser(User user);

    public List<User> getAllUsers();

    public User getUser(long userId);

    public List<Topic> getSubscribedTopicsByUser(User user);

    public void addAlertToUser(long userId, Alert alert);

    public void addTopicToUser(long userId, Topic topic);

    public void markAlertAsRead(long userId, Alert alert);
}

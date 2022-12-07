/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.service;

import com.woowup.woowup.challenge.model.Alert;
import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import com.woowup.woowup.challenge.repository.UserRepository;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserServiceImpl implements UserService {

    // Atributo que almacena una instancia de la clase UserRepository
    private final UserRepository userRepository;

    // Constructor de la clase
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Métodos de la clase
    @Override
    public User addUser(String name, String email) {
        User newUser = new User(name, email);
        this.userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void updateUser(long userId, String name, String email) {
        User userToUpdate = this.userRepository.findById(userId);
        userToUpdate.setName(name);
        userToUpdate.setEmail(email);
        this.userRepository.update(userToUpdate);
    }

    @Override
    public void deleteUser(User user) {
        User userToDelete = this.userRepository.findById(user.getUserId());
        this.userRepository.delete(userToDelete);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<Topic> getSubscribedTopicsByUser(User user) {
        return this.userRepository.getSubscribedTopics(user);
    }

    @Override
    public User getUser(long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public void addAlertToUser(long userId, Alert alert) {
        User usrToAddAlert = this.userRepository.findById(userId);
        usrToAddAlert.addAlert(alert);
        this.userRepository.update(usrToAddAlert);
    }

    @Override
    public void addTopicToUser(long userId, Topic topic) {
        User usrToAddTopic = this.userRepository.findById(userId);
        usrToAddTopic.subscribeToTopic(topic);
        this.userRepository.update(usrToAddTopic);
    }

    @Override
    public void markAlertAsRead(long userId, Alert alert) {
        User usrToMarkReadedAlert = this.userRepository.findById(userId);
        usrToMarkReadedAlert.markAlertAsRead(alert);
        this.userRepository.update(usrToMarkReadedAlert);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woowup.woowup.challenge.repository;

import com.woowup.woowup.challenge.model.Topic;
import com.woowup.woowup.challenge.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UserRepository {

    // Atributo que almacena la lista de usuarios en el sistema
    private List<User> users;

    // Atributo que lleva el conteo de los usuarios agregados al sistema
    private long userCounter = 0;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    /**
     * Método que devuelve un usuario con el identificador especificado
     *
     * @param userId
     * @return
     */
    public User findById(long userId) {
        return this.users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Método que devuelve un usuario con el email especificado
     *
     * @param email
     * @return
     */
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Método que devuelve un usuario con el nombre especificado
     *
     * @param name
     * @return
     */
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    /**
     * Método que agrega un usuario a la lista de usuarios
     *
     * @param user
     */
    public void save(User user) {
        // Asignamos el identificador único del usuario utilizando el contador
        user.setUserId(this.userCounter);
        // Incrementamos el contador para el próximo usuario
        this.userCounter++;
        this.users.add(user);
    }

    public void update(User user) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, user);
        }
    }

    public void delete(User user) {
        users.remove(user);
    }

    public List<Topic> getSubscribedTopics(User user) {
        User userWithTopics = this.users.stream()
                .filter(usr -> usr.getUserId() == user.getUserId())
                .findFirst()
                .orElse(null);
        return userWithTopics.getSubscribedTopics(user);
    }
}

package com.coffeever.coffeever.service;

import com.coffeever.coffeever.model.User;
import com.coffeever.coffeever.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService {

    @Autowired
    UserRepository userRepository;

    //google id ile databaseden user bulur
    public User findUserById(Long google_id) {
        return userRepository.findById(google_id).orElse(null);
    }

    //database'e yeni user ekler
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // database'den user siler
    public void deleteUser(User user) {
         userRepository.delete(user);
    }

    //user database update
    public User updateUser(User user) {

        User existingUser = userRepository.findById(user.getGoogle_id()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setMail(user.getMail());

        return userRepository.save(existingUser);
    }


}

package com.bruno.workshopspringmongo.services;

import com.bruno.workshopspringmongo.domain.User;
import com.bruno.workshopspringmongo.repositories.UserRepository;
import com.bruno.workshopspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
        return user;
    }
}

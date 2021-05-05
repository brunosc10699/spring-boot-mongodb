package com.bruno.workshopspringmongo.services;

import com.bruno.workshopspringmongo.domain.User;
import com.bruno.workshopspringmongo.dto.UserDTO;
import com.bruno.workshopspringmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}

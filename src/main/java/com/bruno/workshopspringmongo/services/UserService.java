package com.bruno.workshopspringmongo.services;

import com.bruno.workshopspringmongo.domain.User;
import com.bruno.workshopspringmongo.dto.UserDTO;
import com.bruno.workshopspringmongo.repositories.UserRepository;
import com.bruno.workshopspringmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(String id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
        return new UserDTO(user);
    }

    public void insert(User user){
        userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void update(User user){
        UserDTO userDTO = findById(user.getId());
        if(userDTO != null) {
            userRepository.save(new User(user.getId(), user.getName(), user.getEmail()));
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado!");
        }
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}

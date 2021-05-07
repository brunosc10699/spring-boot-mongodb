package com.bruno.workshopspringmongo.resources;

import com.bruno.workshopspringmongo.dto.UserDTO;
import com.bruno.workshopspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bruno.workshopspringmongo.domain.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = userService.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        UserDTO userDTO = new UserDTO(userService.findById(id));
        return ResponseEntity.ok().body(userDTO);
    }
}

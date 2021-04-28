package com.bruno.workshopspringmongo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.workshopspringmongo.domain.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = new ArrayList<>();
        list.add(new User("1", "Bruno", "bruno@gmail.com"));
        list.add(new User("2", "Nélio", "nelio@gmail.com"));
        list.add(new User("3", "Washington", "wwahington@gmail.com"));
        return ResponseEntity.ok().body(list);
    }
}

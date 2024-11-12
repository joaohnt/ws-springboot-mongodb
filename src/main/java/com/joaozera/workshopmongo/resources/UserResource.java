package com.joaozera.workshopmongo.resources;

import com.joaozera.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User jotas = new User("1", "jotas", "jotas@gmail.com");
        User luva = new User("2", "luva", "receba@gmail.com");
        List<User> list = new ArrayList<User>(Arrays.asList(jotas, luva));
        return ResponseEntity.ok().body(list);
    }
}

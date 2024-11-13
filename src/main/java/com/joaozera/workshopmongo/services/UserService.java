package com.joaozera.workshopmongo.services;

import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.repository.UserRepository;
import com.joaozera.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
}

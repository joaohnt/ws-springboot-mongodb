package com.joaozera.workshopmongo.services;

import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.dto.UserDTO;
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

    public User insert(User user) {
        return repo.insert(user);
    }

    public void delete(String id) {
        findById(id); // para lançar a execao se necessario
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

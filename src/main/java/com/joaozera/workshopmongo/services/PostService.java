package com.joaozera.workshopmongo.services;

import com.joaozera.workshopmongo.domain.Post;
import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.dto.UserDTO;
import com.joaozera.workshopmongo.repository.PostRepository;
import com.joaozera.workshopmongo.repository.UserRepository;
import com.joaozera.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public List<Post> findByTitle(String txt) {
        return repo.searchTitle(txt);
    }
    public List<Post> fullSearch(String txt, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(txt, minDate, maxDate);
    }
}

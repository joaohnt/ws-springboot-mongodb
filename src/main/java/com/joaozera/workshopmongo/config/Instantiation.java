package com.joaozera.workshopmongo.config;

import com.joaozera.workshopmongo.domain.Post;
import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.dto.AuthorDTO;
import com.joaozera.workshopmongo.dto.CommentDTO;
import com.joaozera.workshopmongo.repository.PostRepository;
import com.joaozera.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.stream.events.Comment;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User carti = new User(null, "Playboi  Carti", "carti@gmail.com");
        User asuka = new User(null, "Asuka Langley", "asuka@gmail.com");
        User shinji = new User(null, "Shinji Ikari", "shinji@gmail.com");

        userRepository.saveAll(Arrays.asList(carti, asuka, shinji));

        Post post1 = new Post(null, sdf.parse("21/03/20242"), "Tão pedindo pra entrar no robô", "Eu não quero", new AuthorDTO(shinji));
        Post post2 = new Post(null, sdf.parse("21/03/20242"), "mo tristeza", "#pprt.......", new AuthorDTO(shinji));
        Post post3 = new Post(null, sdf.parse("25/03/2024"), "tsc tsc tsc", "Shinji não faz nada, o Gendo só fica mandando, e eu que tenho que salvar o mundo sozinha!",new AuthorDTO(asuka) );
        Post post4 = new Post(null, sdf.parse("21/03/20242"), "FWEAH", "JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE", new AuthorDTO(carti));

        CommentDTO c1 = new CommentDTO("SEYUHH FWAEHHH", sdf.parse("22/02/2024"), new AuthorDTO(carti));
        CommentDTO c2 = new CommentDTO("ENTRA NO ROBÔ SHINJI", sdf.parse("26/02/2024"), new AuthorDTO(asuka));
        CommentDTO c3 = new CommentDTO("Eu nunca vou dropar o album", sdf.parse("05/09/2024"), new AuthorDTO(carti));

        post1.getComments().addAll(Arrays.asList(c2, c3));
        post3.getComments().addAll(Arrays.asList(c1));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        shinji.getPosts().addAll(Arrays.asList(post1, post2));
        asuka.getPosts().add(post3);
        carti.getPosts().add(post4);

        userRepository.save(carti);
        userRepository.save(asuka);
        userRepository.save(shinji);

    }
}

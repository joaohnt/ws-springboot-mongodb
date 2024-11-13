package com.joaozera.workshopmongo.config;

import com.joaozera.workshopmongo.domain.Post;
import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.repository.PostRepository;
import com.joaozera.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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

        User carti = new User(null, "Playboi  Carti", "carti@gmail.com");
        User asuka = new User(null, "Asuka Langley", "asuka@gmail.com");
        User shinji = new User(null, "Shinji Ikari", "shinji@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/20242"), "Tão pedindo pra entrar no robô", "Eu não quero", shinji);
        Post post2 = new Post(null, sdf.parse("21/03/20242"), "mo tristeza", "#pprt.......", shinji);
        Post post3 = new Post(null, sdf.parse("25/03/2024"), "tsc tsc tsc", "Shinji não faz nada, o Gendo só fica mandando, e eu que tenho que salvar o mundo sozinha!",asuka );
        Post post4 = new Post(null, sdf.parse("21/03/20242"), "FWEAH", "JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE JUMPOUTTHEHOUSE", carti);

        userRepository.saveAll(Arrays.asList(carti, asuka, shinji));
        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

    }
}

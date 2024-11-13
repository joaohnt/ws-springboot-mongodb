package com.joaozera.workshopmongo.config;

import com.joaozera.workshopmongo.domain.User;
import com.joaozera.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User rei = new User(null, "Rei Anayami", "rei@gmail.com");
        User asuka = new User(null, "Asuka Langley", "asuka@gmail.com");
        User shinji = new User(null, "Shinji Ikari", "shinji@gmail.com");

        userRepository.saveAll(Arrays.asList(rei, asuka, shinji));
    }
}

package com.Spring.Boot.java_web.config;

import com.Spring.Boot.java_web.Repository.Repository;
import com.Spring.Boot.java_web.entitits.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private Repository Repository;
//Assim que o programa inicialialisar os usuarios seram criados
    //usando commandLineRnner e o metodo run
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        // salvando os dados o banco de dados
        Repository.saveAll(Arrays.asList(u1, u2));


    }
}

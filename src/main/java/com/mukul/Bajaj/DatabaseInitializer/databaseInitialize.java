package com.mukul.Bajaj.DatabaseInitializer;

import com.mukul.Bajaj.Entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class databaseInitialize implements CommandLineRunner {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception{
        mongoTemplate.save(new Sequence("user_sequence",0));
    }
}

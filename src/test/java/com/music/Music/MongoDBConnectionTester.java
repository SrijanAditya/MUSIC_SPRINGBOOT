package com.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDBConnectionTester implements CommandLineRunner {

    @Autowired
    @Qualifier("userMongoTemplate")
    private MongoTemplate userMongoTemplate;
    
    @Autowired
    @Qualifier("songMongoTemplate")
    private MongoTemplate songMongoTemplate;
    
    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("========= MongoDB Connection Test =========");
            System.out.println("User Database: " + userMongoTemplate.getDb().getName());
            System.out.println("Song Database: " + songMongoTemplate.getDb().getName());
            
            // Check if collections exist
            System.out.println("User collections: " + userMongoTemplate.getCollectionNames());
            System.out.println("Song collections: " + songMongoTemplate.getCollectionNames());
            
            System.out.println("MongoDB connection test completed successfully!");
        } catch (Exception e) {
            System.err.println("⚠️ MongoDB Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
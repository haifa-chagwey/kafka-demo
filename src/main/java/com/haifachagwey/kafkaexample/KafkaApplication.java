package com.haifachagwey.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    // Sending a string to the topic
//    @Bean
//    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            for (int i = 0; i < 9; i++) {
//                kafkaTemplate.send("amigoscode", "Hello Kafka :)");
//            }
//        };
//    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 9; i++) {
                kafkaTemplate.send("amigoscode", new Message("Hello Kafka :)", LocalDateTime.now()));
            }
        };
    }

}

package com.haifachagwey.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    // Kafka take the key as a string and the value as a string
//    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Message> kafkaTemplate;

// Sending a string
//    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    // Sending a custom object
    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody Message request) {
        Message message = new Message(request.message(), LocalDateTime.now());
//        kafkaTemplate.send("amigoscode", request.message());
        kafkaTemplate.send("amigoscode", message);

    }
}

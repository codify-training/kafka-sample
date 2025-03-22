package com.example.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="bus-booking", groupId = "group_id")
    public void listen(String message){
        if(message.contains("retry")){
            System.out.println("Simulating failure mechanism");
            throw new RuntimeException("Exception thrown");
        }
        System.out.println("Message::: "+ message);
    }
}

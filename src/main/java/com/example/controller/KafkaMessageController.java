package com.example.controller;

import com.example.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaMessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send-message")
    public String consumeMessage(@RequestParam String message){
        kafkaProducer.sendMessage(message);
        return "Message Sent";
    }

}

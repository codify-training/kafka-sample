package com.example.producer;

import com.example.model.BusBooking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message){
       /* final BusBooking busBooking = new BusBooking(message, "test", "21", System.currentTimeMillis());
        ObjectMapper mapper = new ObjectMapper();
        String data = "";
        try {
            data = mapper.writeValueAsString(busBooking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send("bus-booking", 1, "myNewKey", data);*/

        kafkaTemplate.send("bus-booking", 1, "myNewKey", message);
    }

}

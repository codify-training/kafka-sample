package com.example.config;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaRetryConfig {
    @Bean
    public DefaultErrorHandler fixedBackOffHandler(KafkaTemplate<String, String> kafkaTemplate) {
        FixedBackOff fixedBackOff = new FixedBackOff(2000L, 3);  // 2 sec delay, 3 retries
        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
                kafkaTemplate,
                (record, ex) -> new TopicPartition(record.topic() + ".DLT", record.partition())
        );
        DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(recoverer, fixedBackOff);
        defaultErrorHandler.addRetryableExceptions(Exception.class);
        return defaultErrorHandler;
    }

}

package com.example.producer;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class KafkaMessageProducerTest {

    @Mock
    KafkaTemplate kafkaTemplate;
    @InjectMocks
    KafkaMessageProducer kafkaMessageProducer;

    @Test
    void sendMessageTest() {
        kafkaMessageProducer.sendMessage("Test");
        verify(kafkaTemplate, atLeast(1)).send(anyString(), anyString());
    }
}

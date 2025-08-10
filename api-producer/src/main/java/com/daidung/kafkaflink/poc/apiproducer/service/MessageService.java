package com.daidung.kafkaflink.poc.apiproducer.service;

import com.daidung.kafkaflink.poc.apiproducer.MQConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, String key, String payload, String eventType) {
    log.info("Sending message {} to topic: {}", payload, topic);
    String correlationId = UUID.randomUUID().toString();
    ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, payload);
    Headers headers = record.headers();
    headers.add(MQConstants.EVENT_TYPE, eventType.getBytes());
    headers.add(MQConstants.CORRELATION_ID, correlationId.getBytes());

    kafkaTemplate.send(record);
    log.info("Message {} produced successfully to topic: {}", payload, topic);
  }
}

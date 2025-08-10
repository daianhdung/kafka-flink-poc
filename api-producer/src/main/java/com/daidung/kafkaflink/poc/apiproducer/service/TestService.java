package com.daidung.kafkaflink.poc.apiproducer.service;

import com.daidung.kafkaflink.poc.apiproducer.setting.BrokerSetting;
import com.daidung.kafkaflink.poc.common.model.EventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final MessageService messageService;
    private final BrokerSetting brokerSetting;
    private final ObjectMapper objectMapper;

    public TestService(MessageService messageService,
                       @Qualifier("topicFlink") BrokerSetting brokerSetting,
                       ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.brokerSetting = brokerSetting;
        this.objectMapper = objectMapper;
    }

    public EventDTO publishEvent(EventDTO eventDTO) {
        try {
            messageService.send(brokerSetting.getTopic(), eventDTO.eventId(), objectMapper.writeValueAsString(eventDTO), String.valueOf(eventDTO.eventType()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return eventDTO;
    }
}

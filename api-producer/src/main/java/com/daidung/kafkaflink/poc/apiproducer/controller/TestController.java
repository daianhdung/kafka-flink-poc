package com.daidung.kafkaflink.poc.apiproducer.controller;

import com.daidung.kafkaflink.poc.apiproducer.service.TestService;
import com.daidung.kafkaflink.poc.common.model.EventDTO;
import com.daidung.kafkaflink.poc.common.utils.ApiResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @PostMapping
    public ResponseEntity<ApiResp<EventDTO>> post(@RequestBody EventDTO eventDTO) {
        return ApiResp.success(testService.publishEvent(eventDTO));
    }
}

package com.daidung.kafkaflink.poc.common.model;

import com.daidung.kafkaflink.poc.common.enums.EventType;

import java.time.Instant;

public record EventDTO(String eventId, String payload, Instant timestamp, EventType eventType) {}
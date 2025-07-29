package com.daidung.kafkaflink.poc.common.model;

import java.time.Instant;

public record EventDTO(String eventId, String payload, Instant timestamp) {}
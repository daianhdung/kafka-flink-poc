package com.daidung.kafkaflink.poc.apiproducer.setting;

import lombok.Data;

@Data
public class BrokerSetting {
    private String topic;
    private int partition;
    private int replica;
}

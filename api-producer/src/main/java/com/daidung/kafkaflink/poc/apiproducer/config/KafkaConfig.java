package com.daidung.kafkaflink.poc.apiproducer.config;

import com.daidung.kafkaflink.poc.apiproducer.setting.BrokerSetting;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.setting.kafka.flink.topic")
    BrokerSetting topicFlink() {
        return new BrokerSetting();
    }

    @Bean
    NewTopic newTopicFlink(@Qualifier("topicFlink") BrokerSetting topic) {
        return TopicBuilder
                .name(topic.getTopic())
                .partitions(topic.getPartition())
                .replicas(topic.getReplica())
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.setting.kafka.test.topic")
    BrokerSetting topicTest() {
        return new BrokerSetting();
    }

    @Bean
    NewTopic newTopicTest(@Qualifier("topicTest") BrokerSetting topic) {
        return TopicBuilder
                .name(topic.getTopic())
                .partitions(topic.getPartition())
                .replicas(topic.getReplica())
                .build();
    }
}

package com.tfkconsult.cab_book_driver.config;

import com.tfkconsult.cab_book_driver.constants.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic locationTopic() {
        return TopicBuilder
                    .name(AppConstant.CAB_LOCATION)
                    .build();
    }

    @Bean
    public NewTopic driverTopic() {
        return TopicBuilder
                .name(AppConstant.Driver_NAME)
                .partitions(5)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic driverJson() {
        return TopicBuilder
                .name(AppConstant.Driver_Object)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic customerObject() {
        return TopicBuilder
                .name(AppConstant.CUSTOMER_OBJECT)
                .partitions(2)
                .replicas(1)
                .build();
    }
}

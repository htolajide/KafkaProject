package com.tfkconsult.service;

import com.tfkconsult.constants.AppConstant;
import com.tfkconsult.dto.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CabLocationService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }

    public void driverProducer(String driver) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstant.Driver_NAME, driver);
        future.whenComplete((result, ex) -> {
            if(ex == null) {
                System.out.println("Sent message: [ " + driver + "] with offset [ " + result.getRecordMetadata().offset() + "]");
            }else {
                System.out.println("Unable to send message " + driver + "due to " + ex.getMessage());
            }
        });
    }

    public void driverSerialise(Driver driver) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstant.Driver_JSON, driver);
            future.whenComplete((result, ex) -> {
                if(ex == null) {
                    System.out.println("Sent message: [ " + driver.toString() + "] with offset [ " + result.getRecordMetadata().offset() + "]");
                }else {
                    System.out.println("Unable to send message " + driver.toString() + "due to " + ex.getMessage());
                }
            });

        } catch(Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
    }
}

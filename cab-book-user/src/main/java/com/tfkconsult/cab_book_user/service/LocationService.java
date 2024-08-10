package com.tfkconsult.service;

import com.tfkconsult.dto.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class LocationService {
    Logger log = LoggerFactory.getLogger(LocationService.class);
//    @KafkaListener(topics = "cab-location", groupId = "user-group")
//    public void cabLocation(String location){
//        log.info(location);
//    }
    @KafkaListener(topics = "driver-json", groupId = "user-group")
    public void driverConsumer(Driver driver){
        log.info("DriverConsumer consume: {}", driver.toString());
    }
//    @KafkaListener(topics = "driver-name", groupId = "user-group")
//    public void driverConsumer2(String driver){
//        log.info("DriverConsumer2 consume: {}", driver);
//    }
//    @KafkaListener(topics = "driver-name", groupId = "user-group")
//    public void driverConsumer3(String driver){
//        log.info("DriverConsumer3 consume: {}", driver);
//    }
//    @KafkaListener(topics = "driver-name", groupId = "user-group")
//    public void driverConsumer4(String driver){
//        log.info("DriverConsumer4 consume: {}", driver);
//    }
//    @KafkaListener(topics = "driver-name", groupId = "user-group")
//    public void driverConsumer5(String driver){
//        log.info("DriverConsumer5 consume: {}", driver);
//    }

}

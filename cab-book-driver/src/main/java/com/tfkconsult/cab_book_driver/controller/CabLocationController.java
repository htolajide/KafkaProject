package com.tfkconsult.controller;

import com.tfkconsult.dto.Driver;
import com.tfkconsult.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    private CabLocationService cabLocationService;

    // Business logic
    @PutMapping
    public ResponseEntity<?> updateLocation () throws InterruptedException {
        int range = 100;
        while(range > 0) {
            cabLocationService.updateLocation(Math.random() + ", " + Math.random());
            Thread.sleep(1000);
            range --;
        }
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }
    @GetMapping("/driver/{driver}")
    public ResponseEntity<?> produceDriver(@PathVariable String driver){
        try{
            for (int i=1; i<=10000; i++) {
                cabLocationService.driverProducer(driver + "-" + i);
            }
            cabLocationService.driverProducer(driver);
            return ResponseEntity.ok("Message send successful");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/driver")
    public ResponseEntity<?> produceDriver(@RequestBody Driver driver){
        try{

            cabLocationService.driverSerialise(driver);
            return ResponseEntity.ok("Driver publish successful");
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}

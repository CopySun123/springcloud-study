package com.copysun.openfeign.consumerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author CopySun
 * @date 2020/11/13 15:16
 */
@Service
@FeignClient(name="producer-service")
public interface ProduceService {

    @GetMapping(value = "/say")
    void producerSay();
}

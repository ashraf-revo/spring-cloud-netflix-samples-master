package com.royclarkson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NumberController {

    private final Logger logger = LoggerFactory.getLogger(NumberController.class);
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/number")
    public String number() {
        ServiceInstance lsi = discoveryClient.getLocalServiceInstance();
        String s = lsi.getHost() + "   " + lsi.getServiceId() + "   " + lsi.getUri() + "   " + lsi.getPort() + "               " + counter.incrementAndGet();
        logger.info("i return *********************************" + s);
        return s;
    }
}
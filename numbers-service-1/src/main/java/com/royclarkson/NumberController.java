package com.royclarkson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NumberController {

    private final Logger logger = LoggerFactory.getLogger(NumberController.class);
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/number")
    public String number() {
        String s = "server-1:" + counter.incrementAndGet();
        logger.info("i return *********************************" + s);
        return s;
    }
}

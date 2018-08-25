package com.okan.springbootjms;

import com.okan.springbootjms.model.Order;
import com.okan.springbootjms.service.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringbootJmsApplication implements ApplicationRunner {
    private static Logger log = LoggerFactory.getLogger(SpringbootJmsApplication.class);

    @Autowired
    private OrderSender orderSender;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 10; i++){
            final Date timeStamp = new Date();
            final String content = i + " - Sending JMS Message using Embedded activeMQ";
            final Order myMessage = new Order(content, timeStamp);
            orderSender.send(myMessage);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJmsApplication.class, args);
    }
}

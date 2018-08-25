package com.okan.springbootjms.service;

import com.okan.springbootjms.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.okan.springbootjms.ActiveMQConfig.ORDER_QUEUE;

@Service
public class OrderSender {

    private static Logger log = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final Order myMessage) {
        log.info("sending with convertAndSend() to queue <" + myMessage + ">");
        jmsTemplate.convertAndSend(ORDER_QUEUE, myMessage);
    }
}

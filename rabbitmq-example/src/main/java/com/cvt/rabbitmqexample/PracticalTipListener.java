package com.cvt.rabbitmqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class PracticalTipListener {
    private static final Logger logger=LoggerFactory.getLogger(PracticalTipListener.class);

    @RabbitListener(queues = RabbitmqExampleApplication.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final SimplePracticalTipMessage message){
        logger.info("Received message with default configuration, SimpleTip ->> {} ",message.toString());
    }
}

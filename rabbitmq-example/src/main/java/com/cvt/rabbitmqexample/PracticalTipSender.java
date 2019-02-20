package com.cvt.rabbitmqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PracticalTipSender  { // class is used to send a messeges

    private static final Logger logger=LoggerFactory.getLogger(PracticalTipSender.class);
    private final RabbitTemplate rabbitTemplate;

    int count=0;

    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendTipMessage(){
        count++;
        PracticalTipMessage tipMessage=
                new PracticalTipMessage("Always use Immutable java class "+count,1,false);

        rabbitTemplate.convertAndSend(
                RabbitmqExampleApplication.EXCHANGE_NAME,
                RabbitmqExampleApplication.ROUTING_KEY,
                tipMessage);
        logger.info("Practical Tip Messege has Sent ..");
    }
}

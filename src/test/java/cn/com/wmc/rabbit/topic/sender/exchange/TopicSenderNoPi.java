package cn.com.wmc.rabbit.topic.sender.exchange;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSenderNoPi {
	 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
    	String context = "topic 中   未使用通配符模式，发给对垒：queueTopic.que";
        System.out.println("Sender : " + context);
        //String exchange, String routingKey, Message message
        this.rabbitTemplate.convertAndSend("mytopicExchange", "queueTopic.que", context);
    }
 
}

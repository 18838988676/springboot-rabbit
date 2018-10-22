package cn.com.wmc.rabbit.only.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnlyHelloSender {
	 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
        String context = "我是发送者： " + new Date();
        System.out.println("发送内容 : " + context);
        this.rabbitTemplate.convertAndSend("firstQueue", context);
    }
 
}

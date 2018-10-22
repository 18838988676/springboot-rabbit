package cn.com.wmc.rabbit.only.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class M2ManyHelloSender {
	 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
    	for (int i = 0; i < 50; i++) {
    		String context = "我是duo发送者2： " + new Date()+"---"+i;
    		System.out.println("发送内容 : " + context);
    		this.rabbitTemplate.convertAndSend("manyQue", context);
			
		}
    }
 
}

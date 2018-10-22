package cn.com.wmc.rabbit.only.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityHelloSender {
	 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send(User user) {
    	for (int i = 0; i <20; i++) {
    		String context = "我是发送者： " + user.toString();
    		System.out.println("发送内容 : " + context);
    		this.rabbitTemplate.convertAndSend("manyQue", context);
			
		}
    }
 
}

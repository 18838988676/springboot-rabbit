package cn.com.wmc.rabbit.fanout.sender.exchange;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
	 
    @Autowired
    private AmqpTemplate rabbitTemplate;
 
    public void send() {
    	 String context = "this  out解放东路设计费辣椒水东方丽景阿里的    ";
         System.out.println("发送内容:" + context);
         this.rabbitTemplate.convertAndSend("myFanoutExchange","", context);
    }
 
}

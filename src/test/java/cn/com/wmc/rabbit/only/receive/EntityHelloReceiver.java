package cn.com.wmc.rabbit.only.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import cn.com.wmc.rabbit.only.sender.User;

@Component  
@RabbitListener(queues = "manyQue")
public class EntityHelloReceiver {
 
    @RabbitHandler
    public void myrec(User user) {
        System.out.println("我是接收者  : " + user);
    }
}

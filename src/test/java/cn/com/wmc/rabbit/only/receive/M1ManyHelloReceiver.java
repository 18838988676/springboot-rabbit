package cn.com.wmc.rabbit.only.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "manyQue")
public class M1ManyHelloReceiver {
 
    @RabbitHandler
    public void receive1(String hello) {
        System.out.println("11我是接收者 m1ManyHelloReceiver，接收内容如下： " + hello);
    }
 
}

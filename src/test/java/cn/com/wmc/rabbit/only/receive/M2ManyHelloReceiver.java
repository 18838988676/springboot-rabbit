package cn.com.wmc.rabbit.only.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "manyQue")
public class M2ManyHelloReceiver {
 
    @RabbitHandler
    public void myreceiv(String hello) {
        System.out.println("22我是接收者 m2ManyHelloReceiver，，接收内容如下：" + hello);
    }
 
}

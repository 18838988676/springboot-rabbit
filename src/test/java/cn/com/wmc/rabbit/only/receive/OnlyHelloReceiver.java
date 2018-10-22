package cn.com.wmc.rabbit.only.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //测试多个M1 M2时 关闭的
@RabbitListener(queues = "firstQueue")
public class OnlyHelloReceiver {
 
    @RabbitHandler
    public void process(String hello) {
        System.out.println("我是接收者  : " + hello);
    }
 
}

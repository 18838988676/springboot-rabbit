package cn.com.wmc.rabbit.fanout.receive.exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component // 测试多个M1 M2时 关闭的
@RabbitListener(queues = "thisfanout.c")
public class FanReceiver3 {
 
    @RabbitHandler
    public void process(String hello) {
        System.out.println("我是接收者 ,我监听：thisfanout.c : " + hello);
    }
 
}

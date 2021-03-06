package cn.com.wmc.rabbit.topic.receive.exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component // 测试多个M1 M2时 关闭的
@RabbitListener(queues = "queueTopic2YesTongpei")
public class TopicReceiver2 {
 
    @RabbitHandler
    public void process(String hello) {
        System.out.println("我是接收者 ,我监听：queueTopic2YesTongpei : " + hello);
    }
 
}

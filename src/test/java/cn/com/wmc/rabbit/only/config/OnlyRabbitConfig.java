package cn.com.wmc.rabbit.only.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//队列配置
@Configuration
public class OnlyRabbitConfig {
    @Bean
    public Queue declareMyQueu() {
        return new Queue("manyQue");
    }
 
}

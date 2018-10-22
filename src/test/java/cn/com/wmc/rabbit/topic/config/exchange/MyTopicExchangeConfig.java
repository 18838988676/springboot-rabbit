package cn.com.wmc.rabbit.topic.config.exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//第五种：通配符模式 
@Configuration
public class MyTopicExchangeConfig {
	
	private static String queueByTopic1="queueTopic1No";
	private static String queueByTopic2="queueTopic2YesTongpei";
	private static String mytopicExchange="mytopicExchange";
	
	
	 @Bean
	 public  TopicExchange myexchange() {
	        return new TopicExchange(MyTopicExchangeConfig.mytopicExchange);
	    }

	 @Bean
	    public Queue declaremyQueue1() {
	        return new Queue(MyTopicExchangeConfig.queueByTopic1);
	    }
	 
	 @Bean
	    public Queue declaremyQueue2() {
	        return new Queue(MyTopicExchangeConfig.queueByTopic2);
	    }
	 
	 @Bean
	 public   Binding myqueuebindingExchange() {								//routingKey  路由建
	        return BindingBuilder.bind(declaremyQueue1()).to(myexchange()).with("queueTopic.que");
	    }

	 //队列2是通配符模式
	 @Bean
	 public   Binding myqueuebindingExchangepipei() {					//routingKey  路由建  通配符
	        return BindingBuilder.bind(declaremyQueue2()).to(myexchange()).with("queueTopic.#");
	    }


}

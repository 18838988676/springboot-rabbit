package cn.com.wmc.rabbit.fanout.config.exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//fanout 订阅者模式
@Configuration
public class MyFanoutExchangeConfig {
	
	  @Bean
	  public FanoutExchange myfanoutExchange() {
	        return new FanoutExchange("myFanoutExchange");
	    }


	@Bean
	public Queue myQueue1() {
		return new Queue("thisfanout.a");
	}
	
	@Bean
	public Queue myQueue2() {
		return new Queue("thisfanout.b");
	}
	
	@Bean
	public Queue myQueue3() {
		return new Queue("thisfanout.c");
	}
	

	
	
	 @Bean
	 public   Binding bindingExchangeA() {
	        return BindingBuilder.bind(myQueue1()).to(myfanoutExchange());
	    }
	 
	    @Bean
	    public    Binding bindingExchangeB() {
	        return BindingBuilder.bind(myQueue2()).to(myfanoutExchange());
	    }
	 
	    @Bean
	    public    Binding bindingExchangeC() {
	        return BindingBuilder.bind(myQueue3()).to(myfanoutExchange());
	    }

}

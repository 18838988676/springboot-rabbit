package cn.com.wmc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.wmc.rabbit.fanout.sender.exchange.FanoutSender;
import cn.com.wmc.rabbit.only.sender.EntityHelloSender;
import cn.com.wmc.rabbit.only.sender.M1ManyHelloSender;
import cn.com.wmc.rabbit.only.sender.M2ManyHelloSender;
import cn.com.wmc.rabbit.only.sender.OnlyHelloSender;
import cn.com.wmc.rabbit.only.sender.User;
import cn.com.wmc.rabbit.topic.sender.exchange.TopicSenderNoPi;
import cn.com.wmc.rabbit.topic.sender.exchange.TopicSenderPi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	 	@Autowired
	    private OnlyHelloSender helloSender;
	 	
	 	
		@Autowired
	    private M1ManyHelloSender m1ManyHelloSender;
		
		@Autowired
	    private M2ManyHelloSender m2ManyHelloSender;
		

		@Autowired
	    private EntityHelloSender entityHelloSender;
		
		
		@Autowired
	    private TopicSenderNoPi topicSenderNoPi;
		@Autowired
	    private TopicSenderPi topicSenderPi;
	 
		@Autowired
	    private FanoutSender fanoutSender;
		
		
		
	 	//一个生产者  一个消费者
	    @Test
	    public void hello() throws Exception {
	        helloSender.send();
	    }

	
	    
	    //需要把firstQue。。那个的接收者关了
	    //一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
	    @Test
		public void testMyan() throws Exception {
	    	m1ManyHelloSender.send();
		}
	    
	    
	    
	    //多个消费者 多个接收者    和一对多一样，接收端仍然会均匀接收到消息
	    @Test
		public void testMyan2() throws Exception {
	    	m1ManyHelloSender.send();
	    	m2ManyHelloSender.send();
		}
	    
	    
	    //发送实体对象  
	    // 不能使用manyQue 这个队列，因为接收者类型不同
	    @Test
	  		public void testEntity() throws Exception {
	    	entityHelloSender.send(new User("1", "1111", "fdlasjflsk"));
	  		}
	    
	    //////////////////开始使用通配符topic模式交换机/Exchange/////////////////////////////////
	    //  Topic  Exchange     topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列
	    
	    
	    //发送2条信息，这2条分别：一个指定路由建，一个不准确指定路由建。发现：带通配的那个 收到2条消息，不带匹配的只收到一条
	    @Test
		public void testTopic() throws Exception {
	    	topicSenderNoPi.send();
	    	topicSenderPi.send();
		}
	    
	    
	    
	    //fanoutSender
	    @Test
		public void testFaout() throws Exception {
			fanoutSender.send();
		}
	    
	    
	    
	    

}

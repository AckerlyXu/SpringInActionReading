package orders.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import orders.db.Order;
import orders.model.Item;
import redis.clients.jedis.Jedis;

@Controller
public class HomeController {
	@RequestMapping("/")
	@ResponseBody
public String Home() {
	
	return "home";
}
	
	@Autowired
	RedisConnectionFactory rcf;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	@RequestMapping("/redisSet")
	@ResponseBody
	public String redisSet() {
	
//		RedisConnection connection=rcf.getConnection();
//		
//		connection.set("greeting".getBytes(), "hello world".getBytes());
//		connection.close();
		redisTemplate.opsForValue().set("world2",new Order(),5,TimeUnit.SECONDS);
//		RedisTemplate<String, String> redisTemplate=new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(rcf);
//	ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//	opsForValue.set("s", "s");
		stringRedisTemplate.opsForValue().set("hello","hello");
	
		return "saved";
	}
	@RequestMapping("/redisGet")
	@ResponseBody
	public String redisGet() {
		
	return redisTemplate.opsForValue().get("world2").toString();
//		RedisTemplate<String, Order> redisTemplate=new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(rcf);
//		
//	ValueOperations<String, Order> vo=	redisTemplate.opsForValue();
//	Order order=vo.get("valueOperationRedisTemplate");
//	return	order.toString();
	
	}
	
}

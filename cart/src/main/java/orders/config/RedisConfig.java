package orders.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@Configuration
@EnableCaching
@ComponentScan(basePackages="orders")
public class RedisConfig {
@Bean
public RedisConnectionFactory redisCF() {
	JedisConnectionFactory cFactory=new JedisConnectionFactory();
	cFactory.setHostName("192.168.25.128");
  cFactory.setPort(6379);//¶Ë¿ÚÄ¬ÈÏÊÇ6379
	return cFactory ;
}
@Bean
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
	  return new StringRedisTemplate(redisConnectionFactory);
	  
}
@Bean 
public RedisTemplate<String, Object>redisTemplate(RedisConnectionFactory redisConnectionFactory){
	Jackson2JsonRedisSerializer<Object> jRedisSerializer=new Jackson2JsonRedisSerializer<>(Object.class);
  
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
            Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL,Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
   template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.setConnectionFactory(redisConnectionFactory);
    template.afterPropertiesSet();

 return template;
}
@Bean
public CacheManager cacheManager(RedisOperations<String, Object> redisOperations) {
	return new  RedisCacheManager(redisOperations);
}
}

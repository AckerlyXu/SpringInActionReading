package orders.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Component;

@Component
public class CacheTest {
	//#this代表当前上下文，第一个#代表spel表达式
	 @Value("#{#this.environment.getProperty('prefix')}")
	 public String prefix;
	 
	 //target代表当前对象
	 //更全的介绍可以看https://www.cnblogs.com/yueshutong/p/9381540.html
@Cacheable(value="getId",key="target.prefix+#id")
	public String getId(String id) {
	
		return new Long(id).toString();
	}
}

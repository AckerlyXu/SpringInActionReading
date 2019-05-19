package orders.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Component;

@Component
public class CacheTest {
	//#this����ǰ�����ģ���һ��#����spel���ʽ
	 @Value("#{#this.environment.getProperty('prefix')}")
	 public String prefix;
	 
	 //target����ǰ����
	 //��ȫ�Ľ��ܿ��Կ�https://www.cnblogs.com/yueshutong/p/9381540.html
@Cacheable(value="getId",key="target.prefix+#id")
	public String getId(String id) {
	
		return new Long(id).toString();
	}
}

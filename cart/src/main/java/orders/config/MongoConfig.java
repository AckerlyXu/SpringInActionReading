package orders.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="orders.db")
//@PropertySource("classpath:")
@ComponentScan("orders")
public class MongoConfig 
extends AbstractMongoConfiguration
{

	
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		
		return "OrdersDB";
	}

	@Override

	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient();
	}
	

	

	

}

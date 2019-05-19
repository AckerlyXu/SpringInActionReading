package orders.web;



import java.util.ArrayList;
import java.util.Collection;

import javax.management.Query;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DBCollection;

import orders.db.Order;
import orders.db.OrderRepository;
import orders.model.Item;



@Controller
@RequestMapping("/order")
public class OrderController {
//	@Autowired
//	MongoOperations mongo;
	@Autowired()

	OrderRepository orderdb;
	@RequestMapping("/save")
	@ResponseBody
	public String saveOrder() {
		Order order=new Order();
		order.setCustomer("xiaoming");
		order.setType("computer");
		Collection<Item> items=new ArrayList<Item>();
		Item item=new Item();
		item.setPrice(10);
		item.setProduct("food");
		item.setQuantity(6);
		items.add(item);
		 item=new Item();
		item.setPrice(10);
		item.setProduct("meat");
		item.setQuantity(20);
		items.add(item);
		order.setItems(items);
	//	mongo.save(order,"order");
		orderdb.save(order);
		return "save ok";
		
		
		
	}
	@ResponseBody
	@RequestMapping("/getAll")
	public String getAll() {
		org.springframework.data.mongodb.core.query.Criteria criteria=org.springframework.data.mongodb.core.query.Criteria.where("type").is("computer");
	org.springframework.data.mongodb.core.query.Query query=org.springframework.data.mongodb.core.query.Query.query(criteria);
	//return mongo.find(query, Order.class).toString();
	return orderdb.findAll().stream().map(order->order.toString()).reduce((a,s)->a.toString()+s.toString()).get();
	//return "a";
	}

}

package orders.db;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import orders.model.Item;

/*import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;*/

@Document
public class Order {
	@Id
private String id;
	@Field("client")
	private String customer;
	private String type;
	
	private Collection<Item> items=new LinkedHashSet<>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", type=" + type + ", items=" + items + "]";
	}


	
}

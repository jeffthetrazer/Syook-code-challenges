package com.logistic.system.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logistic.system.obj.Customers;
import com.logistic.system.obj.DeliveryVehicles;
import com.logistic.system.obj.Item;
import com.logistic.system.obj.Order;

public class LogisticsSystemService {
    private static Logger logger = LoggerFactory.getLogger(LogisticsSystemService.class);

	
	private List<Order> orders;
	private List<Item> items;
    private List<DeliveryVehicles> vehicles;
    private List<Customers> customers;

    public LogisticsSystemService()
    {
        this.orders = new ArrayList<Order>();
        this.vehicles = new ArrayList<DeliveryVehicles>();
        this.customers = new ArrayList<Customers>();
        this.items = new ArrayList<Item>();
    }
    
    /**
     * This method is to create a customer
     * @param customer - Customers Object
     */
    public void createCustomer(Customers customer) {
    	logger.debug("inside create customer method");
    	customers.add(customer);
    	logger.info("customer - "+customer+" added");
    }
    
    /**
     * This method is for getting all customers
     * @return 
     */
    public List<Customers> getAllCustomers() {
    	logger.debug("inside getAllCustomers method");
		return customers;
    }
    
    /**
     * This method is to add the item
     * @param item
     */
    public void createItem(Item item) {
    	logger.debug("inside create item method");
    	items.add(item);
    	logger.info("item - "+item+" added");
    }
    
    /**
     * This method is for getting all item
     * @return
     */
    public List<Item> getAllItems() {
    	logger.debug("inside getAllItems method");
		return items;
    }
    
    /**
     * This method is for updating item
     * @param id - id of item need to get updated
     * @param item - item object containing fields which will get updated
     */
    public void updateItem(int id, Item item) {
    	logger.debug("inside update item method");
    	//iterator over list of item to get the item whose value need to be updated
    	for(Item itm:items) {
    		//if id passed in argument is same as the id stored in list than update its value
    		if(id==itm.getItemId()) {
    			if(item.getName()!=null) {
    				itm.setName(item.getName());
    			}
    			if(item.getPrice()!=0) {
    				itm.setPrice(item.getPrice());
    			}
    			logger.info("updated item : "+itm);
    		}
    	}
    }
    
    /**
     * This method is to create the delivery vehicles
     * @param deliveryVehicles
     */
    public void createDeliveryVehicle(DeliveryVehicles deliveryVehicles) {
    	logger.debug("inside create DeliveryVehicle  method");
    	vehicles.add(deliveryVehicles);
    }
    
    
    /**
     * This method is to get all the delivery vehicles
     */
    public List<DeliveryVehicles> getAllDeliveryVehicle() {
    	logger.debug("inside get all DeliveryVehicle  method");
    	return vehicles;
    }
    
    /**
     * This method is to get all the delivery vehicles
     * @param id
     */
    public void updateDeliveryVehicle(int id, DeliveryVehicles deliveryVehicles) {
    	logger.debug("inside update  DeliveryVehicle  method");
    	for(DeliveryVehicles deliveryVeh: vehicles) {    		
    			//if id passed in argument is same as the id stored in list than update its value (right now only updating 
    		    // registration number and city)
        		if(id==deliveryVeh.getId()) {
        			if(deliveryVehicles.getRegistrationNumber()!=null) {
        				deliveryVeh.setRegistrationNumber(deliveryVehicles.getRegistrationNumber());
        			}
        			if(deliveryVehicles.getCity()!=null) {
        				deliveryVeh.setCity(deliveryVehicles.getCity());
        			}
        			logger.info("updated delivery vehicle : "+deliveryVeh);
        		}
    		}  	
    	
    }
    
    /**
     * This method is to create an order
     * @param order - Order Object
     */
    public void createOrder(Order order) {
    	logger.debug("inside create   order  method");
    	//1. get the item id from order request so that we can get the item price from items list
    	int itemId=order.getItemId();
    	
    	
    	//2. get the item detail from items list to get the price of an item
    	for(Item itm:items) {
    		if(itemId==itm.getItemId()) {
    			//price of item (based on item id) is set for order
    			order.setPrice(itm.getPrice());
    		}
    	}
    	
    	//3. get the delivery vehicle detail  based on vehicle id passed in order
    	int deliveryVehicleId=order.getDeliveryVehicleId();
    	
    	//3.1 get the delivry vehcile city from vehicle list
    	String deliveryVehicleCity=null;
    	for(DeliveryVehicles deliveryVehicle:vehicles) {
    		if(deliveryVehicleId==deliveryVehicle.getId()) {
    			deliveryVehicleCity=deliveryVehicle.getCity();   			
    			
    		}
    	}
    	
    	//4. get the customer detail based on customer id passed in order
    	int customerId=order.getCustomerId();
    	
    	//4.1 get the customer city from customers list
    	String customerCity=null;
    	for(Customers customer:customers) {
    		if(customerId==customer.getCustomerId()) {
    			customerCity=customer.getCity();
    		}
    	}
    	
    	
    	//5. compare delivery city and customer city if same then place order else cant place an order
    	if(customerCity!=null && deliveryVehicleCity!=null && customerCity.equalsIgnoreCase(deliveryVehicleCity)) {
    		//check if the vehicle activeOderCount (deliverVehicle) is not < 2. If yes create an order else can't create order
    		for(DeliveryVehicles deliveryVehicle:vehicles) {
    			if(deliveryVehicleId==deliveryVehicle.getId()) {
        			int activeOrderCount=deliveryVehicle.getActiveOrderCount(); 
        			activeOrderCount++;
        			logger.info("activeOrderCount "+activeOrderCount);
        			if(activeOrderCount<=2) {
        				//create the order ; activeOrderCount<2
        				orders.add(order);
        				
        				//increment the active order count of delivery vehicle
        				deliveryVehicle.setActiveOrderCount(activeOrderCount);
        			}else {
        				logger.error("cannot create order because active order count for the selected vehicle is > 2");
        			}
        			
        		}
    		}
    		
    	}else {
    		logger.error("Cannot create order because customer city is not same as delivery city");
    	}
    }

    /**
     * This method is to set the order delivered to true for a specific order
     * @param orderId - id of the order which is delivered
     */
	public void orderDelivered(int orderId) {
		logger.debug("inside order delivered  method");
		for(Order order:orders) {
			if(orderId==order.getOrderId()) {
				order.setDelivered(true);
				
				//once setDelivered is set to true; decrement the active order count of associated delivery vehicle.
				int deliveryVehicleId=order.getDeliveryVehicleId();
				
				for(DeliveryVehicles deliveryVehicle:vehicles) {
					if(deliveryVehicleId==deliveryVehicle.getId()) {
						int count=deliveryVehicle.getActiveOrderCount();
						deliveryVehicle.setActiveOrderCount(count-1);
					}
				}
			}
		}
	}
	
	public List<Order> getAllOrder(){
		logger.debug("inside get all orders method");
		return orders;
	}
    
}

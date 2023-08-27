package com.logistic.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logistic.system.obj.Customers;
import com.logistic.system.obj.DeliveryVehicles;
import com.logistic.system.obj.Item;
import com.logistic.system.obj.Order;
import com.logistic.system.obj.VehicleType;
import com.logistic.system.service.LogisticsSystemService;

public class LogisticsSystemMain {
    private static Logger logger = LoggerFactory.getLogger(LogisticsSystemMain.class);


	public static void main(String[] args) {
		//create Logistics System Sevice class object because all the API are written there and data are stored in list
		LogisticsSystemService logisticsSystemService=new LogisticsSystemService();
		
		// Populating some pre-filled data
		
		// create some items
		Item itm1=new Item(1,"LUX", 10);
		Item itm2=new Item(2,"DOVE", 50);
		Item itm3=new Item(3,"JBL", 1000);
		
		//add item in items list of logisticsSystemService
		logisticsSystemService.createItem(itm1);
		logisticsSystemService.createItem(itm2);
		logisticsSystemService.createItem(itm3);
		
		logger.info(" List of all items "+logisticsSystemService.getAllItems());
		
		
		// create some customer
		Customers cust1=new Customers(1, "Deep", "Delhi");
		Customers cust2=new Customers(2, "Ravi", "Bangalore");
		
		//add customer in customers list of logisticsSystemService
		logisticsSystemService.createCustomer(cust1);
		logisticsSystemService.createCustomer(cust2);
		
		logger.info(" List of all customers "+logisticsSystemService.getAllCustomers());
		
		
		// create some delivery Vehicle
		DeliveryVehicles deliveryVehicles1=new DeliveryVehicles(1, "Del001", VehicleType.TRUCK, "Delhi");
		DeliveryVehicles deliveryVehicles2=new DeliveryVehicles(2, "BANG001", VehicleType.BIKE, "Bangalore");
		
		
		//add delivery vehicle in vehicle list of logisticsSystemService
		logisticsSystemService.createDeliveryVehicle(deliveryVehicles1);
		logisticsSystemService.createDeliveryVehicle(deliveryVehicles2);
		
		logger.info(" List of all delivery vehicle "+logisticsSystemService.getAllDeliveryVehicle());

		
		//request to create an order
		Order order1=new Order();
		order1.setOrderId(1);
		order1.setItemId(1);
		order1.setCustomerId(1);
		order1.setDeliveryVehicleId(1);
		
		Order order2=new Order();
		order2.setOrderId(2);
		order2.setItemId(2);
		order2.setCustomerId(1);
		order2.setDeliveryVehicleId(1);
		
		
		// remember after creating order 1 and order 2, activeOrderCount will be 2 so adding further order will give error
		logisticsSystemService.createOrder(order1);
		logisticsSystemService.createOrder(order2);
		
		logger.info(" List of all orders "+logisticsSystemService.getAllOrder());
		logger.info(" List of all vehclie  "+logisticsSystemService.getAllDeliveryVehicle());
		
		// after finishing delivery of order 1, activeOrderCount will decremented making a scope to add more order for the  vehical
		logisticsSystemService.orderDelivered(1);
		
		logger.info("**********After delivry of order 1******");
		logger.info(" List of all orders "+logisticsSystemService.getAllOrder());
		logger.info(" List of all vehclie  "+logisticsSystemService.getAllDeliveryVehicle());
		
		Order order3=new Order();
		order3.setOrderId(3);
		order3.setItemId(3);
		order3.setCustomerId(1);
		order3.setDeliveryVehicleId(1);
		
		Order order4=new Order();
		order4.setOrderId(4);
		order4.setItemId(1);
		order4.setCustomerId(1);
		order4.setDeliveryVehicleId(1);
		
		logisticsSystemService.createOrder(order3);
		
		logger.info("**********After delivry of order 1---- Adding order 3 ******");
		logger.info(" List of all orders "+logisticsSystemService.getAllOrder());
		logger.info(" List of all vehclie  "+logisticsSystemService.getAllDeliveryVehicle());
		
		//trying to add order 4 will give error because active Delivery count for vehicale 1 is already 2
		logisticsSystemService.createOrder(order4);

		

	}

}

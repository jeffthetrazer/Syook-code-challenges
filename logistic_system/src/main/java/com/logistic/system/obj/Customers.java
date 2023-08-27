package com.logistic.system.obj;

public class Customers {
	
	private int customerId;
    private String name;
    private String city;
    
    
	public Customers(int customerId, String name, String city) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.city = city;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", name=" + name + ", city=" + city + "]";
	}
    
    

}

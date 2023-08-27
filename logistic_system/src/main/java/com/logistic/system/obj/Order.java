package com.logistic.system.obj;

public class Order {
	
	private static int count = 0;
	private int orderId;
	private int itemId;
	private int price;
	private int customerId;
	private int deliveryVehicleId;
	private boolean isDelivered;
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Order.count = count;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getDeliveryVehicleId() {
		return deliveryVehicleId;
	}
	public void setDeliveryVehicleId(int deliveryVehicleId) {
		this.deliveryVehicleId = deliveryVehicleId;
	}
	public boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemId=" + itemId + ", price=" + price + ", customerId=" + customerId
				+ ", deliveryVehicleId=" + deliveryVehicleId + ", isDelivered=" + isDelivered + "]";
	}
	
	
	

}

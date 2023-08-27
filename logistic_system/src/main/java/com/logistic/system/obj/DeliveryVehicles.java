package com.logistic.system.obj;

public class DeliveryVehicles {
	
	private int id;
    private String registrationNumber;
    private VehicleType vehicleType;
    private String city;
    
    
    
 public DeliveryVehicles(int id, String registrationNumber, VehicleType vehicleType, String city) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.vehicleType = vehicleType;
		this.city = city;
	}
// make sure the value is not updated/set in create & update API
    private int activeOrderCount=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getActiveOrderCount() {
		return activeOrderCount;
	}
	public void setActiveOrderCount(int activeOrderCount) {
		this.activeOrderCount = activeOrderCount;
	}
	@Override
	public String toString() {
		return "DeliveryVehicles [id=" + id + ", registrationNumber=" + registrationNumber + ", vehicleType="
				+ vehicleType + ", city=" + city + ", activeOrderCount=" + activeOrderCount + "]";
	}
	
    
    
    

}

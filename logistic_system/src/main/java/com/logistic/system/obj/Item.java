package com.logistic.system.obj;

public class Item {

	private int itemId;
	private String name;
    private int price;
    
    
    public Item(int itemId, String name, int price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }
  
    public int getPrice() { return price; }
  
    public void setPrice(int price) { this.price = price; }

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}

	
    
    
}

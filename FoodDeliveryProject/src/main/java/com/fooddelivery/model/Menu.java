package com.fooddelivery.model;

public class Menu {

	private int menu_id;
	private int rest_id;
	private String item_name;
	private String description;
	private float price;
	private boolean available;
	public Menu(int menu_id, int rest_id, String item_name, String description, float price, boolean available) {
		super();
		this.menu_id = menu_id;
		this.rest_id = rest_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.available = available;
	}
	public Menu(int menu_id,String item_name, String description, float price, boolean available) {
		// TODO Auto-generated constructor stub
		this.menu_id = menu_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
		this.available = available;
	}
	public Menu(){
		super();
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRest_id() {
		return rest_id;
	}
	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return menu_id +" " + item_name + " "+ description + " " + price + " " + available;
	}

}

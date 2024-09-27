package com.fooddelivery.model;

public class Restaurant {

	private int id;
	private String name;
	private String cuisive_Type;
	private int delivery_time;
	private boolean isActive;
	private int rating;
	public Restaurant(int id, String name, String cuisive_Type, int delivery_time, boolean isActive, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.cuisive_Type = cuisive_Type;
		this.delivery_time = delivery_time;
		this.isActive = isActive;
		this.rating = rating;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisive_Type() {
		return cuisive_Type;
	}
	public void setCuisive_Type(String cuisive_Type) {
		this.cuisive_Type = cuisive_Type;
	}
	public int getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return id + " " + name + " " + cuisive_Type + " "+ delivery_time + " " + isActive + " " + rating;
	}
	
}

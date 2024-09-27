package com.fooddelivery.model;

public class OrderItems {

	private int order_item_id;
	private int order_id;
	private int menu_id;
	private int quantity;
	private int sub_tot;
	public OrderItems(int order_item_id, int order_id, int menu_id, int quantity, int sub_tot) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.sub_tot = sub_tot;
	}
	public OrderItems(int order_id, int menu_id, int quantity, int sub_tot) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.sub_tot = sub_tot;
	}
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSub_tot() {
		return sub_tot;
	}
	public void setSub_tot(int sub_tot) {
		this.sub_tot = sub_tot;
	}
	
	@Override
	public String toString() {
		return order_item_id + " " + order_id + " " + menu_id+ " " + quantity + " " + sub_tot;
	}
	

	

}

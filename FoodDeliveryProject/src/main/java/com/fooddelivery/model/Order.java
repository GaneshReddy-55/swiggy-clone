package com.fooddelivery.model;

public class Order {

	private int order_id;
	private int user_id;
	private int rest_id;
	private int tot_amt;
	private String status;
	private String date;
	private String payment_option;
	
	public Order(int order_id, int user_id, int rest_id,int tot_amt, String status, String date,
			String payment_option) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.rest_id = rest_id;
		this.tot_amt = tot_amt;
		this.status = status;
		this.date = date;
		this.payment_option = payment_option;
	}
	public Order(int user_id, int rest_id, int tot_amt, String status, String date, String payment_option) {
		super();
		this.user_id = user_id;
		this.rest_id = rest_id;
		this.tot_amt = tot_amt;
		this.status = status;
		this.date = date;
		this.payment_option = payment_option;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRest_id() {
		return rest_id;
	}
	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}
	public int getTot_amt() {
		return tot_amt;
	}
	public void setTot_amt(int tot_amt) {
		this.tot_amt = tot_amt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPayment_option() {
		return payment_option;
	}
	public void setPayment_option(String payment_option) {
		this.payment_option = payment_option;
	}
	@Override
	public String toString() {
		return order_id + " " + user_id + " " + rest_id + " " + tot_amt + " " + status + " " + date + " " + payment_option;
	}

}

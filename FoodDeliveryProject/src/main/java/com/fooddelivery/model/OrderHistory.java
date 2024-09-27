package com.fooddelivery.model;

public class OrderHistory {

	private int orderHistoryId;
	private int userId;
	private int orderId;
	private int tot_amt;
	private String date;
	private String status;
	public OrderHistory(int orderHistoryId, int userId, int orderId,  String date, int tot_amt, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.tot_amt = tot_amt;
		this.date = date;
		this.status = status;
	}
	public OrderHistory(int userId, int orderId, String date, int tot_amt, String status) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.tot_amt = tot_amt;
		this.date = date;
		this.status = status;
	}
	
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTot_amt() {
		return tot_amt;
	}
	public void setTot_amt(int tot_amt) {
		this.tot_amt = tot_amt;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return orderHistoryId + " " + userId + " " + orderId + " " + tot_amt + " " + date + " " + status;
	}

}

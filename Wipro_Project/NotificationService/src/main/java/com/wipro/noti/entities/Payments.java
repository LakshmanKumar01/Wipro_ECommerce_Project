package com.wipro.noti.entities;

public class Payments {
	private Long id;
	private Long amount;
	private String status;
	private Long orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long long1) {
		this.amount = long1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Payments(Long id, Long amount, String status, Long orderId) {
		super();
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.orderId = orderId;
	}

	public Payments() {
		super();
	}

}

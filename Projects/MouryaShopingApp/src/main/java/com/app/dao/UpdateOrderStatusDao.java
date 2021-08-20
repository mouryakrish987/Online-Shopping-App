package com.app.dao;

public interface UpdateOrderStatusDao {
	public int updateOrderStatus(String status, int id);
	public int updateorderStatusByCustomerId(String status, int id);
}

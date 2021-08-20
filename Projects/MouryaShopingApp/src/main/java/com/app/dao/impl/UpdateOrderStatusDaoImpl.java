package com.app.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.UpdateOrderStatusDao;
import com.app.utlity.JavaDbConnection;

public class UpdateOrderStatusDaoImpl implements UpdateOrderStatusDao{
	public static Logger log =Logger.getLogger(UpdateOrderStatusDaoImpl.class);
	//UPDATE `project1`.`order` SET `orderStatus` = 'ordered' WHERE (`orderid` = '1');
	int c=0;
	@Override
	public int updateOrderStatus(String status, int id) {
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="UPDATE project1.order SET orderStatus = ? WHERE orderid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, id);
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}	
		return c;
	}
	@Override
	public int updateorderStatusByCustomerId(String status, int id) {
		try(Connection connection = JavaDbConnection.getConnection()){
			String sql="UPDATE project1.order SET orderStatus = ? WHERE customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, id);
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal error occues please contact suport team");
		}	
		return c;
	}

}

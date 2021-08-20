package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDao;
import com.app.model.Product;
import com.app.utlity.JavaDbConnection;



public class ProductSearchDaoImpl implements ProductSearchDao{
	public static Logger log= Logger.getLogger(ProductSearchDaoImpl.class);
	@Override
	public List<Product> getProductById(int id) {
		List<Product> productList = new ArrayList<>();
		try(Connection connection= JavaDbConnection.getConnection()){
			String sql="Select * from product where productid= ?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductid(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setNumberofproducts(resultSet.getInt("NumberofProducts"));
				product.setPrice(resultSet.getDouble("price"));
				product.setProductType(resultSet.getString("producttype"));
				productList.add(product);
				}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error occurs Please contact suport team");
		}
		return productList;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> productList = new ArrayList<>();
		try(Connection connection= JavaDbConnection.getConnection()){
			String sql="Select * from product where productname= ?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductid(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setNumberofproducts(resultSet.getInt("NumberofProducts"));
				product.setPrice(resultSet.getDouble("price"));
				product.setProductType(resultSet.getString("producttype"));
				productList.add(product);
				}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error occurs Please contact suport team");
		}
		return productList;
	}

	@Override
	public List<Product> getProductByType(String typeOfProduct) {
		List<Product> productList = new ArrayList<>();
		try(Connection connection= JavaDbConnection.getConnection()){
			String sql="Select * from product where producttype= ?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, typeOfProduct);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductid(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setNumberofproducts(resultSet.getInt("NumberofProducts"));
				product.setPrice(resultSet.getDouble("price"));
				product.setProductType(resultSet.getString("producttype"));
				productList.add(product);
				}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error occurs Please contact suport team");
		}
		return productList;
	}

	@Override
	public List<Product> getAllproducts() {
		List<Product> productList = new ArrayList<>();
		try(Connection connection= JavaDbConnection.getConnection()){
			String sql="Select * from product";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				product.setProductid(resultSet.getInt("productid"));
				product.setProductName(resultSet.getString("productname"));
				product.setNumberofproducts(resultSet.getInt("NumberofProducts"));
				product.setPrice(resultSet.getDouble("price"));
				product.setProductType(resultSet.getString("producttype"));
				productList.add(product);
				}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn("Internal Error occurs Please contact suport team");
		}
		return productList;
	}

}

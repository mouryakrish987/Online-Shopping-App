package com.Tesing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.app.dao.CustomerLoginDao;
import com.app.dao.CustomerRegistrationDao;
import com.app.dao.EmployeeLoginDao;
import com.app.dao.impl.CustomerLoginDaoImpl;
import com.app.dao.impl.CustomerRegistrationDaoImpl;
import com.app.dao.impl.EmployeeLoginDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;
import com.app.service.ProductSearchService;
import com.app.service.impl.ProductSearchServiceImpl;

public class TestingMouryaShopingApp {
	@Test
	public void testCustomerLoginStatus() throws BusinessException {
		CustomerLoginDao cld= new CustomerLoginDaoImpl();
		int result=cld.customerLoginStatus("mourya@gmail.com", "mourya123");
		assertEquals(1, result);
	}
	@Test
	public void testCustomerLoginStatus1() throws BusinessException {
		CustomerLoginDao cld= new CustomerLoginDaoImpl();
		int result=cld.customerLoginStatus("abcd@gmail.com", "abcd123");
		assertEquals(4, result);
	}
	@Test
	public void testEmployeeLoginStatus() throws BusinessException {
		EmployeeLoginDao eld= new EmployeeLoginDaoImpl();
		int result1=eld.employeeLoginStatus("mourya@gmail.com", "mourya123");
		assertEquals(1, result1);
	}
	@Test
	public void testCustomerRegistration() throws BusinessException {
		CustomerRegistrationDao crd = new CustomerRegistrationDaoImpl();
		int c=crd.customerRegistrationStatus("Phain", "phain@gmail.com", "phani123", "3451267890");
		assertEquals(1, c);
	}
	@Test
	public void testViewAllProducts() {
		ProductSearchService pss = new ProductSearchServiceImpl();
		List<Product> productList= new ArrayList<>();
		productList = pss.getAllProducts();
		assertEquals(null, productList);
	}
}

package com.app.main;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.AddProductToCartDao;
import com.app.dao.AddProductsDao;
import com.app.dao.CartOperationsDao;
import com.app.dao.CustomerLoginDao;
import com.app.dao.CustomerRegistrationDao;
import com.app.dao.EmployeeLoginDao;
import com.app.dao.PlaceOrderDao;
import com.app.dao.UpdateOrderStatusDao;
import com.app.dao.impl.AddProductToCartDAoImpl;
import com.app.dao.impl.AddProductsDaoImpl;
import com.app.dao.impl.CustomerLoginDaoImpl;
import com.app.dao.impl.CustomerRegistrationDaoImpl;
import com.app.dao.impl.EmployeeLoginDaoImpl;
import com.app.dao.impl.PlaceOrderDaoImpl;
import com.app.dao.impl.UpdateOrderStatusDaoImpl;
import com.app.dao.impl.CartOperationsDaoImpl;
import com.app.exception.BusinessException;
import com.app.model.Customers;
import com.app.model.Product;
import com.app.service.ProductSearchService;
import com.app.service.ViewCustomerService;
import com.app.service.impl.ProductSearchServiceImpl;
import com.app.service.impl.ViewCustomerServiceImpl;

public class MainApp {
	private static Logger log= Logger.getLogger(MainApp.class);
	public static void main(String[] args)  {
		log.info("welcom to shoping app");
		log.info("==================================");
		int ch=0;
		String email, password;
		Scanner sc= new Scanner(System.in);
		do {
			log.info("1) Employee login");
			log.info("2) Customer login");
			log.info("3) Customer registration");
			log.info("4) Exit");
			log.info("Enter your choice (1-4)");
			try {
			ch=Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				log.info(e.getMessage());
			}
			switch(ch) {
			case 1:
				log.info("Enter email id:");
				email=sc.nextLine();
				log.info("Enter Password");
				password=sc.nextLine();
				EmployeeLoginDao eld= new EmployeeLoginDaoImpl();
				int result1=0;
				try {
					result1 = eld.employeeLoginStatus(email, password);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(result1==1) {
					log.info("Login Successfully");
					int ch1=0;
					do {
						log.info("1) Add products");
						log.info("2) view customer");
						log.info("3) Update order status ");
						log.info("4) log out");
						log.info("Enter your choice...");
						ch1=Integer.parseInt(sc.nextLine());
						switch(ch1){
						case 1:
							AddProductsDao adp =new AddProductsDaoImpl();
							//int c=adp.addProducts("Earphones", 10, 600.00, "electronic");
							//System.out.println(c);
							String productname,productType;
							int count;
							double price;
							log.info("Enter product name");
							productname=sc.nextLine();
							log.info("Enter quantity of product");
							count=Integer.parseInt(sc.nextLine());
							log.info("Enter price");
							price=Integer.parseInt(sc.nextLine());
							log.info("Enter product type");
							productType=sc.nextLine();
							int c = 0;
							try {
								c = adp.addProducts(productname, count, price, productType);
							} catch (BusinessException e) {
								// TODO Auto-generated catch block
								log.info(e.getMessage());
							}
							if(c==1) {
								log.info("Sucessfully product are added");
							}
							else {
								log.error("Invalid Entry");
							}
							break;
						case 2:
							int ch2=0;
							do {
								ViewCustomerService vcs = new ViewCustomerServiceImpl();
								log.info("1) View Customer by ID");
								log.info("2) View Customer by name");
								log.info("3) View Customer by email");
								log.info("4) View Customer by phone number");
								log.info("5) Go to previous menu");
								log.info("Enter your Choice ");
								ch2=Integer.parseInt(sc.nextLine());
								switch(ch2) {
								case 1:
									log.info("Enter id:");
									int id=Integer.parseInt(sc.nextLine());
									List<Customers> customerList= new ArrayList<>();
									
									customerList= vcs.viewCustomerById(id);
									customerList.stream().forEach(System.out::println);
									break;
								case 2:
									log.info("Enter name:");
									String name=sc.nextLine();
									List<Customers> customerList1= new ArrayList<>();
									customerList= vcs.viewCustomerByName(name);
									customerList1.stream().forEach(System.out::println);
									break;
								case 3:
									log.info("Enter email:");
									String email1=sc.nextLine();
									List<Customers> customerList2= new ArrayList<>();
									customerList= vcs.viewCustomerByName(email1);
									customerList2.stream().forEach(System.out::println);
									break;
								case 4:
									log.info("Enter phone Number:");
									String phoneNo=sc.nextLine();
									List<Customers> customerList3= new ArrayList<>();
									customerList= vcs.viewCustomerByName(phoneNo);
									customerList3.stream().forEach(System.out::println);
									break;
								case 5:
									log.info("Thanku you visiting");
									break;
								default:
									log.info("Invalid choice... please eneter between(1-5)");
									break;
								}
								
							}while(ch2!=5);
							break;
						case 3:
							UpdateOrderStatusDao uosd= new UpdateOrderStatusDaoImpl();
							//int c1=uosd.updateOrderStatus("order_received", 1);
							//System.out.println(c1);
							log.info("Enter id ");
							int orderid=Integer.parseInt(sc.nextLine());
							int c1=uosd.updateOrderStatus("Shipped", orderid);
							if(c1==1) {
								log.info("order Status Updated");
							}
							else {
								log.info("Invalid order id");
							}
							break;
						case 4:
							log.info("For further details please login again");
							break;
						default:
							log.info("Invalid choice... please enter value between(1-3)");
							break;
						
						}
					}while(ch1!=4);
				}
				break;
			case 2:
				log.info("Enter email id:");
				email=sc.nextLine();
				log.info("Enter Password");
				password=sc.nextLine();
				CustomerLoginDao cld= new CustomerLoginDaoImpl();
				int result=0;
				try {
					result = cld.customerLoginStatus(email, password);
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				
				if(result>=1) {
					log.info("Login Successfully");
					log.info("Welcom "+email+ "what you wanna do today ?");
					
					int ch2=0;
					do {
						log.info("1) Search products");
						log.info("2) View cart");
						log.info("3) update status of order");
						log.info("4) logout");
						log.info("Enter your Choice");
						ch2=Integer.parseInt(sc.nextLine());
						List<Product> productList =new ArrayList<>();
						ProductSearchService pss = new ProductSearchServiceImpl();
						switch(ch2) {
							case 1:
//								ProductSearchService psd= new ProductSearchServiceImpl();
//								productList=psd.getAllProducts();
//								productList.stream().forEach(System.out::println);
								
								int ch3=0;
								do {
									log.info("1) Display all products");
									log.info("2) Display product by product id");
									log.info("3) Display the products by product name");
									log.info("4) Display the products by type of product");
									log.info("5) Go to previous menu");
									log.info("Enter your choice");
									ch3=Integer.parseInt(sc.nextLine());
									switch(ch3) {
									case 1:
										
										productList = pss.getAllProducts();
										productList.stream().forEach(System.out::println);
										break;
									case 2:
										log.info("Enter product id");
										int productId=Integer.parseInt(sc.nextLine());
										productList = pss.getProductById(productId);
										productList.stream().forEach(System.out::println);
										break;
									case 3:
										log.info("Enter product name");
										String productName= sc.nextLine();
										productList = pss.getProductByName(productName);
										productList.stream().forEach(System.out::println);
										break;
									case 4:
										log.info("Enter type of product do you want");
										String productType= sc.nextLine();
										productList = pss.getProductByName(productType);
										productList.stream().forEach(System.out::println);
										break;
									case 5:
										log.info("Please visit again");
										break;
									}
									log.info("Do you want to add product to cart then press 1");
									int press=Integer.parseInt(sc.nextLine());
									if(press==1) {
										log.info("Enter product id that need to add to cart");
										int pid= Integer.parseInt(sc.nextLine());
										AddProductToCartDao aptc= new AddProductToCartDAoImpl();
										int c3 = 0;
										try {
											c3 = aptc.AddProductToCart(pid, result);
										} catch (BusinessException e) {
											// TODO Auto-generated catch block
											log.error(e.getMessage());
										}
										if(c3==1) {
											log.info("Sucessfully added to cart");
										}
										else {
											log.info("Invalid entry");
										}
									}
									
								}while(ch3!=5);
								
								break;
							case 2:
								CartOperationsDao cartOperationsDao = new CartOperationsDaoImpl();
								List<Product> productList3 = new ArrayList<>();
							try {
								productList3=cartOperationsDao.viewCart(result);
							} catch (BusinessException e) {
								// TODO Auto-generated catch block
								log.error(e.getMessage());
							}
								//System.out.println(result);
								productList3.stream().forEach(System.out::println);
								log.info("Total price of products in cart");
							double totalPrice=0;
							try {
								totalPrice = cartOperationsDao.totalPrice(result);
							} catch (BusinessException e) {
								// TODO Auto-generated catch block
								log.error(e.getMessage());
							}
								log.info(totalPrice);
								log.info("If you want to order a product please enter 1");
								int orderA= Integer.parseInt(sc.nextLine());
								if(orderA==1) {
									log.info("Enter product id to order the product");
									int productid=Integer.parseInt(sc.nextLine());
									PlaceOrderDao placeOrderDao = new PlaceOrderDaoImpl();
									int c1 = 0;
									try {
										c1 = placeOrderDao.placeOrder(productid, result);
									} catch (BusinessException e) {
										log.error(e.getMessage());
									}
									if(c1==1) {
										log.info("Order placed");
									}
									else {
										log.info("Invalid product id");
									}
								}
								break;
							case 3:
								System.out.println(result);
								UpdateOrderStatusDao uosd= new UpdateOrderStatusDaoImpl();
								int c1=uosd.updateorderStatusByCustomerId("Received", result);
								if(c1==1) {
									log.info("order Status Updated");
								}
								else {
									log.info("You have not order any item");
								}
								
								break;
							case 4:
								log.info("Thank you for using the app please visite the again");
								break;
							default:
								log.info("Invalid choice...   Enter choice between (1-3)");
								break;
						}
						
						
					}while(ch2!=4);
				}
				
				
				break;
			case 3:
				//String name, String email, String password, String phoneNo
				log.info("Enter your name");
				String name = sc.nextLine();
				log.info("Enter your email");
				String emailR = sc.nextLine();
				log.info("Enter password");
				String passwordR=sc.nextLine();
				log.info("Enter your phone number");
				String phoneNo= sc.nextLine();
				CustomerRegistrationDao crd = new CustomerRegistrationDaoImpl();
				int c = 0;
				try {
					c = crd.customerRegistrationStatus(name, emailR, passwordR, phoneNo);
				} catch (BusinessException e) {
					log.error(e.getMessage());
				}
				if(c==1) {
					log.info("Registration sucessfull... for further process please login to app");
					
				}
				
				break;
			case 4:
				log.info("Thanks for using app");
				break;
			default:
				log.info("Invalid choice...   Enter choice between (1-4)");
				break;
			}
			
			
		}while(ch!=4);
			sc.close();
	}
	
	
}

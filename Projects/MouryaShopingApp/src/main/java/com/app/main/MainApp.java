package com.app.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class MainApp {
	private static Logger log= Logger.getLogger(MainApp.class);
	public static void main(String[] args) {
		log.info("welcom to shoping app");
		log.info("==================================");
		int ch=0;
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
				log.info("Under Construction");
				break;
			case 2:
				log.info("Under Construction");
				break;
			case 3:
				log.info("Under Constuction");
				break;
			case 4:
				log.info("Thanks for using app");
				break;
			default:
				log.info("Invalid choice...   Enter choice between (1-4)");
				break;
			}
			
			
		}while(ch!=4);
	}
}
